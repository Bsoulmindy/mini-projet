package com.terroir.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.terroir.entities.enumerations.Categorie;
import com.terroir.entities.enumerations.Unite;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int produit_id;

    private String produit_nom;

    private String produit_desc;

    private float produit_prix;

    @Enumerated(EnumType.STRING)
    private Unite produit_unite;

    @Enumerated(EnumType.STRING)
    private Categorie produit_categorie;

    private String produit_image;


    // LES METHODES
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit", cascade = { CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REMOVE })
    @Builder.Default
    List<ProduitMatiereAsso> produitMatieresAsso = new ArrayList<ProduitMatiereAsso>();

    @ManyToOne
    @JoinColumn(name = "cooperative_idref")
    private Cooperative cooperative;

    @OneToMany(mappedBy = "produit", cascade = {CascadeType.REMOVE})
    private List<CommandeProduitAsso> commandeProduitAssos;
}
