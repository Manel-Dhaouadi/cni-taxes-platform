package com.taxes.service;

import com.taxes.entity.User;
import com.taxes.entity.Municipalite;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Value("${frontend.url}")
    private String frontendUrl;

    public void sendRegistrationConfirmation(User user) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(user.getEmail());
            helper.setSubject("Confirmation d'inscription - Plateforme Taxes");

            Context context = new Context();
            context.setVariable("nom", user.getPrenom() + " " + user.getNom());
            context.setVariable("email", user.getEmail());
            context.setVariable("frontendUrl", frontendUrl);

            String html = templateEngine.process("email/registration-confirmation", context);
            helper.setText(html, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            System.err.println("Erreur lors de l'envoi de l'email: " + e.getMessage());
        }
    }

    public void sendValidationEmail(User user, Municipalite municipalite) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            String password = "TempPassword123!"; // À générer aléatoirement

            helper.setTo(user.getEmail());
            helper.setSubject("Validation de votre compte - Plateforme Taxes");

            Context context = new Context();
            context.setVariable("nom", user.getPrenom() + " " + user.getNom());
            context.setVariable("municipalite", municipalite.getNom());
            context.setVariable("email", user.getEmail());
            context.setVariable("password", password);
            context.setVariable("frontendUrl", frontendUrl);

            String html = templateEngine.process("email/validation-confirmation", context);
            helper.setText(html, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            System.err.println("Erreur lors de l'envoi de l'email: " + e.getMessage());
        }
    }
}
