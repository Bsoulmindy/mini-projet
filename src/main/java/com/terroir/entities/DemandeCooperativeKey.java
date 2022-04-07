package com.terroir.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeCooperativeKey implements Serializable {
	private int cooperative_idref;
	private int personne_idref;
}
