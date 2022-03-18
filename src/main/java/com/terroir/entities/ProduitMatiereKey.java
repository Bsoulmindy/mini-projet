package com.terroir.entities;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProduitMatiereKey implements Serializable {
    int produit_idref;
    int matiere_premiere_idref;
}
