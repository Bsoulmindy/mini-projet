package com.terroir.entities;


import lombok.*;

import javax.persistence.*;

import com.terroir.entities.enumerations.Unite;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProduitMatiereAsso {

    @EmbeddedId
    ProduitMatiereKey idref=new ProduitMatiereKey();

    private int matiere_premiere_quantite;

    @Enumerated(EnumType.STRING)
    private Unite matiere_premiere_unite;


    // LES METHODES
    @ManyToOne(cascade = {CascadeType.ALL})
    @MapsId("produit_idref")
    @JoinColumn(name = "produit_idref")
    Produit produit;

    @ManyToOne(cascade = {CascadeType.ALL})
    @MapsId("matiere_premiere_idref")
    @JoinColumn(name = "matiere_premiere_idref")
    MatierePremiere matierePremiere;

    @ManyToOne
    @JoinColumn(name="origine_idref")
    private Origine origine;
}
