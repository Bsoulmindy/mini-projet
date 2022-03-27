package com.terroir.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Index {
	//TODO: tous doit avoir : active, authentified et personneNom
	@GetMapping(path = "")
	public String acceuil() { return "Accueil"; } //TODO: newProducts et popularProducts

	@GetMapping(path = "category") //TODO : ?categorie, ?matierePremiere , ?origine
	public String category() { return "Category"; } //TODO: products, categories, matierePremieres & origines

	@GetMapping(path = "panier")
	public String panier() { return "Panier"; } //TODO: products

	@GetMapping(path = "contact")
	public String contact() { return "Contact"; }

	@GetMapping(path = "tracking")
	public String tracking() { return "Tracking"; } //TODO: commandes

	@GetMapping(path = "cooperatives") //TODO : ?cooperative , ?origine
	public String cooperatives() { return "Cooperatives"; } //TODO: cooperatives, secteurActivite & origines

	@GetMapping(path = "cooperativeDesc") //TODO : ?cooperative_id
	public String cooperativeDesc() { return "CooperativeDesc"; } // TODO : cooperative

	@GetMapping(path = "produit") //TODO : ?produit_id
	public String produit() { return "Produit"; } //TODO : product

	@GetMapping(path = "connexion")
	public String connexion() { return "Connexion"; }

	@GetMapping(path = "inscription")
	public String inscription() { return "Inscription"; }
}
