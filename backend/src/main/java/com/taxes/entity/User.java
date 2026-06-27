package com.taxes.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "utilisateurs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String prenom;

    @Column(unique = true, nullable = false, length = 20)
    private String cin;

    @Column(unique = true, nullable = false, length = 255)
    private String email;

    @Column(length = 50)
    private String telephone;

    @Column(length = 500)
    private String adresse;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "municipalite_id")
    private Municipalite municipalite;

    @Enumerated(EnumType.STRING)
    private StatutUser statut = StatutUser.EN_ATTENTE;

    @Column(name = "date_inscription")
    private LocalDateTime dateInscription;

    @Column(name = "date_validation")
    private LocalDateTime dateValidation;

    @Column(name = "derniere_connexion")
    private LocalDateTime derniereConnexion;

    private Boolean actif = true;

    @PrePersist
    protected void onCreate() {
        dateInscription = LocalDateTime.now();
    }

    // ===== GETTERS =====
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getCin() { return cin; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public String getAdresse() { return adresse; }
    public String getMotDePasse() { return motDePasse; }
    public Role getRole() { return role; }
    public Municipalite getMunicipalite() { return municipalite; }
    public StatutUser getStatut() { return statut; }
    public LocalDateTime getDateInscription() { return dateInscription; }
    public LocalDateTime getDateValidation() { return dateValidation; }
    public LocalDateTime getDerniereConnexion() { return derniereConnexion; }
    public Boolean getActif() { return actif; }

    // ===== SETTERS =====
    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setCin(String cin) { this.cin = cin; }
    public void setEmail(String email) { this.email = email; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public void setRole(Role role) { this.role = role; }
    public void setMunicipalite(Municipalite municipalite) { this.municipalite = municipalite; }
    public void setStatut(StatutUser statut) { this.statut = statut; }
    public void setDateInscription(LocalDateTime dateInscription) { this.dateInscription = dateInscription; }
    public void setDateValidation(LocalDateTime dateValidation) { this.dateValidation = dateValidation; }
    public void setDerniereConnexion(LocalDateTime derniereConnexion) { this.derniereConnexion = derniereConnexion; }
    public void setActif(Boolean actif) { this.actif = actif; }

    public enum Role {
        SUPER_ADMIN,
        AGENT_MUNICIPAL
    }

    public enum StatutUser {
        EN_ATTENTE,
        ACTIF,
        DESACTIVE
    }
}
