package com.taxes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  // Pour les tâches programmées (transfert vers قباضة)
public class TaxesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxesApplication.class, args);
        System.out.println("========================================");
        System.out.println("🚀 APPLICATION TAXES LOCATIVES DÉMARRÉE");
        System.out.println("📍 URL: http://localhost:8080");
        System.out.println("📚 API Docs: http://localhost:8080/swagger-ui.html");
        System.out.println("========================================");
    }
}
