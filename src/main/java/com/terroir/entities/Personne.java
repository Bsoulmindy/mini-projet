package com.terroir.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Personne {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int personne_id;

	private String personne_nom;



	@OneToOne
	@JoinColumn(name = "compte_idref", nullable = false)
	private Compte compte;
	@OneToOne(mappedBy = "personne")
	private DemandeCooperative demandeCooperative;
}
