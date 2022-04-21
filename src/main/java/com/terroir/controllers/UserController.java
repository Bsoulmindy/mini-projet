package com.terroir.controllers;

import javax.servlet.http.HttpServletRequest;

import com.terroir.entities.enumerations.SecteurActivite;
import com.terroir.exception.FormException;
import com.terroir.services.CompteService;
import com.terroir.services.CooperativeService;
import com.terroir.services.OrigineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlleur dédié aux utilisateurs
 */
@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired CompteService compteService;
	@Autowired OrigineService origineService;
	@Autowired CooperativeService cooperativeService;

	@GetMapping(path = "tracking")
	public String tracking(Model model)
	{
		model.addAttribute("commandes", compteService.getAllCommandesOfUser());
		model.addAttribute("active", "Espace");
		return "Tracking"; 
	}

	@GetMapping(path = "devenirCoop")
	public String devenirCoopForm(Model model) {
		model.addAttribute("active", "Espace");
		model.addAttribute("secteurActivites", SecteurActivite.values());
		model.addAttribute("origines", origineService.getAlOrigines());

		return "DevenirCooperative";
	}

	/**
	 * Créer une demande pour devenir un coopérative
	 */
	@PostMapping(path = "devenirCoop")
	public String devenirCoop(Model model, String nom,String activite, String origine) {

		
		try {
			cooperativeService.devenirCooperative(nom, activite, origine, compteService.recupererPersonneActuel());
		} catch (FormException e) {
			model.addAttribute("error", e.getMessage());
			return devenirCoopForm(model);
		}
		model.addAttribute("success", "Demande créé avec succès");
		return devenirCoopForm(model);
	}

	/**
	 * Acheter en se basant sur les cookies
	 */
	@GetMapping(path = "/achat")
	public String achat(Model model, HttpServletRequest request) { 

		compteService.acheter(request.getCookies());
		return "Accueil";
	} 
}
