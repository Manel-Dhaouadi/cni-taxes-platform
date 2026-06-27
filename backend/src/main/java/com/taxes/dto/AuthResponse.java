package com.taxes.dto;

public class AuthResponse {
    private String token;
    private String email;
    private String role;
    private String nom;
    private String prenom;
    private Long municipaliteId;
    private String message;

    // Constructeur par défaut
    public AuthResponse() {}

    // Constructeur avec tous les paramètres
    public AuthResponse(String token, String email, String role, String nom, 
                        String prenom, Long municipaliteId, String message) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.municipaliteId = municipaliteId;
        this.message = message;
    }

    // ===== GETTERS =====
    public String getToken() { return token; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public Long getMunicipaliteId() { return municipaliteId; }
    public String getMessage() { return message; }

    // ===== SETTERS =====
    public void setToken(String token) { this.token = token; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setMunicipaliteId(Long municipaliteId) { this.municipaliteId = municipaliteId; }
    public void setMessage(String message) { this.message = message; }
}
