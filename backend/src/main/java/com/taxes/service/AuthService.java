package com.taxes.service;

import com.taxes.dto.AuthRequest;
import com.taxes.dto.AuthResponse;
import com.taxes.dto.RegisterRequest;
import com.taxes.dto.ValidationResponse;
import com.taxes.entity.User;
import com.taxes.entity.Municipalite;
import com.taxes.repository.UserRepository;
import com.taxes.repository.MunicipaliteRepository;
import com.taxes.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final MunicipaliteRepository municipaliteRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final UserDetailsService userDetailsService;
    private final EmailService emailService;

    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getMotDePasse())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateToken(authentication);

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        return new AuthResponse(
                token,
                user.getEmail(),
                user.getRole().name(),
                user.getNom(),
                user.getPrenom(),
                user.getMunicipalite() != null ? user.getMunicipalite().getId() : null,
                "Connexion réussie"
        );
    }

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }

        if (userRepository.existsByCin(request.getCin())) {
            throw new RuntimeException("Ce CIN est déjà utilisé");
        }

        User user = new User();
        user.setCin(request.getCin());
        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setEmail(request.getEmail());
        user.setTelephone(request.getTelephone());
        user.setAdresse(request.getAdresse());
        user.setMotDePasse(passwordEncoder.encode(request.getMotDePasse()));
        user.setRole(User.Role.AGENT_MUNICIPAL);
        user.setStatut(User.StatutUser.EN_ATTENTE);
        user.setActif(true);

        userRepository.save(user);

        // Envoyer email de confirmation
        emailService.sendRegistrationConfirmation(user);

        return new AuthResponse(
                null,
                user.getEmail(),
                user.getRole().name(),
                user.getNom(),
                user.getPrenom(),
                null,
                "Inscription réussie. En attente de validation par l'administrateur."
        );
    }

    @Transactional
    public ValidationResponse validateUser(Long userId, Long municipaliteId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        Municipalite municipalite = municipaliteRepository.findById(municipaliteId)
                .orElseThrow(() -> new RuntimeException("Municipalité non trouvée"));

        user.setStatut(User.StatutUser.ACTIF);
        user.setMunicipalite(municipalite);
        user.setDateValidation(java.time.LocalDateTime.now());
        userRepository.save(user);

        // Envoyer email de validation
        emailService.sendValidationEmail(user, municipalite);

        return new ValidationResponse(true, "Agent validé avec succès");
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }
}
