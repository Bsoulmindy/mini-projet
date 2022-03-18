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
    @Column(name = "id")
    private Long idMatierePremiere;

    private String nom;

    @OneToMany(mappedBy = "matierePremiere",cascade = CascadeType.PERSIST)
    List<ProduitMatiereAsso> produitMatieres=new ArrayList<>();

}
