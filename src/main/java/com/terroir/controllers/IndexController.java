package com.terroir.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.terroir.services.CategoryService;
import com.terroir.services.CooperativeService;
import com.terroir.services.MatierePremiereServie;
import com.terroir.services.OrigineService;
import com.terroir.services.ProduitService;
import com.terroir.entities.Cooperative;
import com.terroir.entities.Produit;
import com.terroir.entities.enumerations.Categorie;
import com.terroir.entities.enumerations.SecteurActivite;
import com.terroir.entities.enumerations.Unite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlleur standard des visiteur
 */
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	ProduitService produitService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	MatierePremiereServie matierePremiereServie;
	@Autowired
	OrigineService origineService;
	@Autowired
	CooperativeService cooperativeService;

	/**
	 * Afficher la page d'accueil tout en affichant qlq produits aléatoires
	 */
	@GetMapping(path = "")
	public String acceuil(Model model) {
		model.addAttribute("active", "Accueil");
		List<Produit> randomProduits = produitService.getRandomProduits(4);
		model.addAttribute("randomProducts", randomProduits);

		return "Accueil";
	}

	@GetMapping(path = "category")
	public String category(Model model, String size) {
		model.addAttribute("active", "Category");
		model.addAttribute("products", produitService.getAllProduits());
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("matierePremieres", matierePremiereServie.getAllMatierePremieres());
		model.addAttribute("origines", origineService.getAlOrigines());

		return "Category";
	}

	@GetMapping(path = "panier")
	public String panier(Model model, HttpServletRequest request) {
		model.addAttribute("active", "Panier");
		model.addAttribute("products", produitService.getProduitsInCookies(request.getCookies()));
		return "Panier";
	}

	@GetMapping(path = "contact")
	public String contact(Model model) {
		model.addAttribute("active", "Contact");

		return "Contact";
	}

	/**
	 * Récupérer les coopératives selon un seul critère qui n'est pas <code>null</code> Si tous les critères sont
	 * <code>null</code>, on retourne tous les coopératives
	 */
	@GetMapping(path = "cooperatives")
	public String cooperatives(Model model, String cooperative, String secteurActivite, String origine) {

		model.addAttribute("active", "Cooperatives");
		model.addAttribute("cooperatives",
				cooperativeService.getCooperatives(cooperative, secteurActivite, origine));
		model.addAttribute("secteurActivites", SecteurActivite.values());
		model.addAttribute("origines", origineService.getAlOrigines());
		return "Cooperatives";

	}

	@GetMapping(path = "cooperatives/desc/{cooperative_id}")
	public String cooperativeDesc(Model model, @PathVariable("cooperative_id") int cooperative_id) {

		Cooperative cooperative = produitService.getCooperativeByID(cooperative_id);
		model.addAttribute("active", "Cooperatives");
		model.addAttribute("cooperative", cooperative);
		return "CooperativeDesc";

	}

	@GetMapping(path = "produit/{produit_id}")
	public String produit(Model model, @PathVariable("produit_id") int produit_id) {

		Produit produit = produitService.getProduitID(produit_id);
		model.addAttribute("active", "Category");
		model.addAttribute("product", produit);

		return "Produit";
	}

	@GetMapping(path = "suiviCommande")
	public String getPageSuiviCommandes(Model model) {
		model.addAttribute("active", "Espace");
		return "suiviCommandes";
	}

	@GetMapping(path = "admin/gererCooperatives")
	public String getPageGestionCooperatives(Model model) {
		model.addAttribute("active", "Espace");
		return "gestionCooperatives";
	}

	@GetMapping(path = "admin/gererMatieresPremieres")
	public String getPageGestionMatieresPremieres(Model model) {
		model.addAttribute("active", "Espace");
		return "gestionMatieresPremieres";
	}

	@GetMapping(path = "admin/gererOrigines")
	public String getPageGestionOrigines(Model model) {
		model.addAttribute("active", "Espace");
		return "gestionOrigines";
	}

	@GetMapping("cooperative/suiviCommandes")
	public String suiviCommandes(Model model) {
		model.addAttribute("commandes", cooperativeService.getCommandesOfCooperative());
		return "suiviCommandes";
	}

	/**
	 * Formulaire afin d'ajouter, modifier ou supprimer un produit
	 */
	@GetMapping(path = "cooperative/gererProduits")
	public String getPageGestionProduits(Model model) {

		model.addAttribute("products", cooperativeService.getProduitsOfCooperative());
		model.addAttribute("matierePremieres", matierePremiereServie.getAllMatierePremieres());
		model.addAttribute("origines", origineService.getAlOrigines());
		model.addAttribute("unites", Unite.values());
		model.addAttribute("categories", Categorie.values());
		return "gestionProduits";
	}

	@GetMapping(path = "error")
	public String error(Model model) {
		return "error";
	}
}
