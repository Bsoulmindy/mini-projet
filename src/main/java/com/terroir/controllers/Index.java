package com.terroir.controllers;

import javax.servlet.http.HttpServletRequest;

import com.terroir.services.CategoryService;
import com.terroir.services.MatierePremiereServie;
import com.terroir.services.OrigineService;
import com.terroir.services.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Index {
	@Autowired ProduitService produitService;
	@Autowired CategoryService categoryService;
	@Autowired MatierePremiereServie matierePremiereServie;
	@Autowired OrigineService origineService;
	//TODO: tous doit avoir : active, authentified et personneNom
	@GetMapping(path = "")
	public String acceuil() { return "Accueil"; } //TODO: newProducts et popularProducts

	@GetMapping(path = "category")
	public String category(Model model) {
		model.addAttribute("products", produitService.getAllProduits());
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("matierePremieres", matierePremiereServie.getAllMatierePremieres());
		model.addAttribute("origines", origineService.getAlOrigines());

		return "Category"; 
	} 

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
