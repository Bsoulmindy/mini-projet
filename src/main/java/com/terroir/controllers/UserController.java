package com.terroir.controllers;

import com.terroir.entities.Compte;
import com.terroir.services.CompteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired CompteService compteService;

	@GetMapping(path = "tracking")
	public String tracking() 
	{
		Compte compte = compteService.recupererCompteActuel();
		System.out.println(compte.getCompte_username());
		return "Tracking"; 
	} 
}
