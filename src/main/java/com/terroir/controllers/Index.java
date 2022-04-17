package com.terroir.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.terroir.entities.Cooperative;
import com.terroir.entities.Produit;
import com.terroir.services.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

 
@RestController
@RequestMapping("/")
public class Index {
	@Autowired ProduitService produitService;
	//TODO: tous doit avoir : active, authentified et personneNom
	@GetMapping(path = "")
	public ModelAndView acceuil() { //TODO: newProducts et popularProducts
		//récupérer l'instance popularProduit
		ModelAndView mav = new ModelAndView("Acceuil");
		List<Produit> popularProduits = produitService.getPopularProduits();
		List<Produit> newProducts = produitService.getNewProducts();
		mav.addObject("popularProduit",popularProduits);
		mav.addObject("newProducts", newProducts);

	 
		return mav;
	}  

	@GetMapping(path = "category") //TODO : ?categorie, ?matierePremiere , ?origine
	public ModelAndView category(PathVariable matierePremiere,PathVariable origine,PathVariable categorie) {
		ModelAndView mav = new ModelAndView("Categoriy");
		List<Produit> produits = produitService.getProduitsByMPandOrigineandCategorie(matierePremiere, origine, categorie);
		mav.addObject("produits", produits);

		return mav;
		
		  
	} //TODO: products, categories, matierePremieres & origines

	@GetMapping(path = "panier")
	public ModelAndView panier(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("Panier");
		mav.addObject("products", produitService.getProduitsInCookies(request.getCookies()));
		return mav;
	} 

	@GetMapping(path = "contact")
	public ModelAndView contact() { 
		ModelAndView mav = new ModelAndView("Contact");
		return mav; 
	}

	@GetMapping(path = "cooperatives") //TODO : ?cooperative , ?origine
	public ModelAndView cooperatives(PathVariable Region,PathVariable Secteur)  { 
		ModelAndView mav = new ModelAndView("Cooperatives");
		List<Cooperative> cooperatives = produitService.getCooperativesbyRegionandSecteur( Region, Secteur);
		mav.addObject("cooperatives", cooperatives);
		return mav;
	 
	} //TODO: cooperatives, secteurActivite & origines

	@GetMapping(path = "cooperativeDesc") //TODO : ?cooperative_id
	public ModelAndView cooperativeDesc(PathVariable cooperative_id)  { 
		ModelAndView mav = new ModelAndView("CooperativeDesc");
		Cooperative cooperative = produitService.getCooperativeDesc( cooperative_id);
		mav.addObject("cooperative", cooperative);
		return mav;
		  
	} // TODO : cooperative

	@GetMapping(path = "produit") //TODO : ?produit_id
	public ModelAndView produit(PathVariable produit_id)  { 
	  	ModelAndView mav = new ModelAndView("Produit");
		Produit produit = produitService.getProduitDesc( produit_id);
        mav.addObject("produit", produit);
		
		return mav;
	} //TODO : product

	
}
