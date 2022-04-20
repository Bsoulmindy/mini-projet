package com.terroir.entities;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CommandeProduitKey implements Serializable {
    int produit_idref;
    int commande_idref;
}
