package com.taxes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rues")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nom;

    @Column(unique = true, nullable = false, length = 50)
    private String code;

    @ManyToOne
    @JoinColumn(name = "secteur_id", nullable = false)
    private Secteur secteur;

    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private Double prixM2Tib = 0.0;

    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private Double prixM2Tnb = 0.0;

    @Column(columnDefinition = "DECIMAL(5,2) DEFAULT 1.0")
    private Double coefficient = 1.0;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @OneToMany(mappedBy = "rue")
    private List<Propriete> proprietes = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }
}
