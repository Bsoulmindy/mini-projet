package com.terroir.controllers;

import javax.validation.Valid;

import com.terroir.entities.form.RegisterCompteForm;
import com.terroir.services.CompteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {
	@Autowired CompteService compteService;

	@GetMapping(path = "connexion")
	public String connexionGET() { return "Connexion"; }

	@GetMapping(path = "inscription")
	public String inscriptionGET() { return "Inscription"; }

	@PostMapping(path = "inscription")
	public String inscriptionPOST(final @Valid  RegisterCompteForm compteForm, final BindingResult bindingResult, final Model model) {
		if(bindingResult.hasErrors()){
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "Inscription";
		    }
	    
		    if(!compteService.creerCompte(compteForm, false)) 
		    {
			model.addAttribute("error", "username  déjà utilisé!");
			return "Inscription";
		    }
	    
		    model.addAttribute("success", true);
	    
		    return "Inscription";
	}
}
