package com.terroir.entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MatierePremiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matiere_premiere_id;

    private String matiere_premiere_nom;

    // LES METHODES
    @OneToMany(mappedBy = "matierePremiere", cascade = CascadeType.PERSIST)
    @Builder.Default
    List<ProduitMatiereAsso> produitMatieres = new ArrayList<ProduitMatiereAsso>();

}
