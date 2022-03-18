package com.terroir.entities;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProduitMatiereAsso {

    @EmbeddedId
    ProduitMatiereKey id=new ProduitMatiereKey();

    @ManyToOne(cascade = {CascadeType.ALL
                         //CascadeType.MERGE,
                         // CascadeType.DETACH,
                         // CascadeType.PERSIST
                        })
    @MapsId("idProduit")
    @JoinColumn(name = "idproduit")
    Produit produit;

    @ManyToOne(cascade = {CascadeType.ALL
                           //CascadeType.MERGE,
                           // CascadeType.DETACH,
                           // CascadeType.PERSIST
                         })
    @MapsId("idMatierePremiere")
    @JoinColumn(name = "idmatiere")
    MatierePremiere matierePremiere;

    @ManyToOne
    private Origine origine;

}
