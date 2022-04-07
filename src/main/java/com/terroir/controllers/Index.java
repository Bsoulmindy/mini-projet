package com.terroir.controllers;

import javax.servlet.http.HttpServletRequest;

import com.terroir.services.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Index {
	@Autowired ProduitService produitService;
	//TODO: tous doit avoir : active, authentified et personneNom
	@GetMapping(path = "")
	public String acceuil() { return "Accueil"; } //TODO: newProducts et popularProducts

	@GetMapping(path = "category") //TODO : ?categorie, ?matierePremiere , ?origine
	public String category() { return "Category"; } //TODO: products, categories, matierePremieres & origines

	@GetMapping(path = "panier")
	public String panier(HttpServletRequest request, Model model) {
		model.addAttribute("products", produitService.getProduitsInCookies(request.getCookies()));
		return "Panier";
	} 

	@GetMapping(path = "contact")
	public String contact() { return "Contact"; }

	@GetMapping(path = "cooperatives") //TODO : ?cooperative , ?origine
	public String cooperatives() { return "Cooperatives"; } //TODO: cooperatives, secteurActivite & origines

	@GetMapping(path = "cooperativeDesc") //TODO : ?cooperative_id
	public String cooperativeDesc() { return "CooperativeDesc"; } // TODO : cooperative

	@GetMapping(path = "produit") //TODO : ?produit_id
	public String produit() { return "Produit"; } //TODO : product

	
}
