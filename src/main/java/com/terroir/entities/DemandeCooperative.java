package com.terroir.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class DemandeCooperative {
	@EmbeddedId
	private DemandeCooperativeKey id;
	private boolean demande_approuvee;



	@OneToOne
	@MapsId("personne_idref")
	private Personne personne;
	@OneToOne
	@MapsId("cooperative_idref")
	private Cooperative cooperative;
}
