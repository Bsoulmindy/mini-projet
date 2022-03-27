package com.terroir.entities.enumerations;

public enum Categorie {
	Insolites("Produits Insolites"),
	Boissons("Boissons"), 
	Soupes("Soupes"), 
	FruitsLegumes("Fruis & Légumes"), 
	Viande("Viande"), 
	Poisson("Poisson"), 
	Laitiers("Produits Laitiers");

	private String name;

    	Categorie(String name) {
        	this.name = name;
   	 }

	public String getName() {
		return this.name;
	}    
}
