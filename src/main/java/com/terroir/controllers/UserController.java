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
import org.springframework.web.servlet.ModelAndView;

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
		return "Tracking"; 
	}

	@GetMapping(path = "devenirCoop")
	public ModelAndView devenirCoopForm() {
		ModelAndView model = new ModelAndView("DevenirCooperative");
		model.addObject("secteurActivites", SecteurActivite.values());
		model.addObject("origines", origineService.getAlOrigines());

		return model;
	}

	/**
	 * Créer une demande pour devenir un coopérative
	 */
	@PostMapping(path = "devenirCoop")
	public ModelAndView devenirCoop(String nom,String activite, String origine) {

		ModelAndView model = new ModelAndView("DevenirCooperative");
		try {
			cooperativeService.devenirCooperative(nom, activite, origine, compteService.recupererPersonneActuel());
		} catch (FormException e) {
			model.addObject("error", e.getMessage());
			return model;
		}
		model.addObject("success", "Demande créé avec succès");
		return model;
	}

	/**
	 * Acheter en se basant sur les cookies
	 */
	@GetMapping(path = "/achat/")
	public String achat(HttpServletRequest request) { 

		compteService.acheter(request.getCookies());
		return "Accueil";
	} 
}
