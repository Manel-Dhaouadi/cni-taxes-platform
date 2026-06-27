package com.taxes.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "municipalites")
public class Municipalite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nom;

    @Column(length = 500)
    private String adresse;

    @Column(name = "code_postal", length = 20)
    private String codePostal;

    @Column(length = 50)
    private String telephone;

    @Column(length = 255)
    private String email;

    @Column(name = "site_web", length = 255)
    private String siteWeb;

    @Column(name = "code_municipalite", unique = true, nullable = false, length = 50)
    private String codeMunicipalite;

    private Boolean statut = true;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @OneToMany(mappedBy = "municipalite", cascade = CascadeType.ALL)
    private List<Secteur> secteurs = new ArrayList<>();

    @OneToMany(mappedBy = "municipalite")
    private List<User> users = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }

    // ===== GETTERS =====
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public String getCodePostal() { return codePostal; }
    public String getTelephone() { return telephone; }
    public String getEmail() { return email; }
    public String getSiteWeb() { return siteWeb; }
    public String getCodeMunicipalite() { return codeMunicipalite; }
    public Boolean getStatut() { return statut; }
    public LocalDateTime getDateCreation() { return dateCreation; }
    public List<Secteur> getSecteurs() { return secteurs; }
    public List<User> getUsers() { return users; }

    // ===== SETTERS =====
    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setEmail(String email) { this.email = email; }
    public void setSiteWeb(String siteWeb) { this.siteWeb = siteWeb; }
    public void setCodeMunicipalite(String codeMunicipalite) { this.codeMunicipalite = codeMunicipalite; }
    public void setStatut(Boolean statut) { this.statut = statut; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }
    public void setSecteurs(List<Secteur> secteurs) { this.secteurs = secteurs; }
    public void setUsers(List<User> users) { this.users = users; }
}
