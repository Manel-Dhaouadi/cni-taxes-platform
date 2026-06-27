package com.taxes.controller;

import com.taxes.dto.AuthRequest;
import com.taxes.dto.AuthResponse;
import com.taxes.dto.RegisterRequest;
import com.taxes.dto.ValidationResponse;
import com.taxes.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/admin/validate/{userId}/{municipaliteId}")
    public ResponseEntity<ValidationResponse> validateUser(
            @PathVariable Long userId,
            @PathVariable Long municipaliteId) {
        return ResponseEntity.ok(authService.validateUser(userId, municipaliteId));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser() {
        return ResponseEntity.ok(authService.getCurrentUser());
    }
}
