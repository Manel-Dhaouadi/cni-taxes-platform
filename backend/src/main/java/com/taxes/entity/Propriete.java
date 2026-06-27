package com.taxes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "proprietes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Propriete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypePropriete type;

    @ManyToOne
    @JoinColumn(name = "rue_id", nullable = false)
    private Rue rue;

    @Column(name = "numero_parcelle", nullable = false, length = 100)
    private String numeroParcelle;

    @Column(name = "numero_cadastral", length = 100)
    private String numeroCadastral;

    @Column(name = "surface_construite", columnDefinition = "DECIMAL(10,2)")
    private Double surfaceConstruite;

    @Column(name = "surface_terrain", columnDefinition = "DECIMAL(10,2)")
    private Double surfaceTerrain;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id", nullable = false)
    private Proprietaire proprietaire;

    @Column(name = "annee_construction")
    private Integer anneeConstruction;

    @Column(name = "nb_etages")
    private Integer nbEtages;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_occupation")
    private TypeOccupation typeOccupation;

    @Enumerated(EnumType.STRING)
    @Column(name = "nature_terrain")
    private NatureTerrain natureTerrain;

    @Enumerated(EnumType.STRING)
    private StatutPropriete statut = StatutPropriete.ACTIF;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }

    public enum TypePropriete {
        MAISON,
        TERRAIN
    }

    public enum TypeOccupation {
        PROPRIETAIRE,
        LOCATAIRE
    }

    public enum NatureTerrain {
        CONSTRUCTIBLE,
        AGRICOLE,
        NON_CONSTRUCTIBLE
    }

    public enum StatutPropriete {
        ACTIF,
        DESACTIVE
    }
}
