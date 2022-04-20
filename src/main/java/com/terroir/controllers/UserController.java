package com.terroir.controllers;

import com.terroir.entities.Compte;
import com.terroir.services.CompteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@GetMapping(path = "tracking")
	public String tracking() //TODO : à vérifier plus tard
	{
		Compte compte = compteService.recupererCompteActuel();
		System.out.println(compte.getCompte_username());
		return "Tracking"; 
	}

	@GetMapping(path = "devenirCoop")
	public ModelAndView devenirCoopForm() { //TODO : secteurActivites, origines
		ModelAndView model = new ModelAndView("DevenirCooperative");

		return model;
	}

	@PostMapping(path = "devenirCoop") //TODO : errors | success
	public ModelAndView devenirCoop(String nom,String activite, String origine) {
		ModelAndView model = new ModelAndView("DevenirCooperative");

		return model;
	}

	@GetMapping(path = "/achat/")
	public String achat() { return "Accueil"; } //TODO : Cookies = {idProduit , Qté}
}
