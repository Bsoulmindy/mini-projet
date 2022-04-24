package com.terroir.entities;

import lombok.*;

import javax.persistence.*;

import com.terroir.entities.enumerations.Unite;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProduitMatiereAsso {

    @EmbeddedId
    ProduitMatiereKey idref = new ProduitMatiereKey();

    private float matiere_premiere_quantite;

    @Enumerated(EnumType.STRING)
    private Unite matiere_premiere_unite;

    // LES METHODES
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("produit_idref")
    @JoinColumn(name = "produit_idref")
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("matiere_premiere_idref")
    @JoinColumn(name = "matiere_premiere_idref")
    private MatierePremiere matierePremiere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origine_idref")
    private Origine origine;
}
