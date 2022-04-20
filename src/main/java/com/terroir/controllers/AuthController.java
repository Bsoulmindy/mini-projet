package com.terroir.controllers;

import javax.validation.Valid;

import com.terroir.configuration.CompteDetailsServiceImpl;
import com.terroir.configuration.JwtRequest;
import com.terroir.configuration.JwtResponse;
import com.terroir.configuration.JwtTokenUtil;
import com.terroir.entities.form.RegisterCompteForm;
import com.terroir.services.CompteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlleur d'authentification : connextion & inscription
 */
@Controller
@RequestMapping("/")
public class AuthController {
	@Autowired CompteService compteService;

	@Autowired JwtTokenUtil jwtTokenUtil;

	@Autowired CompteDetailsServiceImpl userDetailsService;

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

	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		compteService.connecterAvecUsername(authenticationRequest);

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
}
