package com.terroir.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Entity
@Data
public class CommandeProduitAsso {
	@EmbeddedId
    	private CommandeProduitKey idref = new CommandeProduitKey();

	private int quantite;



	@ManyToOne()
	@MapsId("produit_idref")
	@JoinColumn(name = "produit_idref")
	private Produit produit;

	@ManyToOne()
	@MapsId("commande_idref")
	@JoinColumn(name = "commande_idref")
	private Commande commande;
}
