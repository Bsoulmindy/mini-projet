package com.terroir.aspect;

import com.terroir.services.CompteService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@Aspect
public class HeaderAspect {
	@Autowired CompteService compteService;

	/**
	 * Injecter les données essentiels qui sont répétés au JSP
	 * <ul>
	 * <li>Est ce que l'utilisateur est authentifié?
	 * <li>Nom du personne connecté
	 * <li>Role du personne
	 * </ul>
	 * @param joinPoint
	 * @param model
	 */
	@Before(value = "execution(* com.terroir.controllers.*.*(..)) and args(model, ..)")  
	public void injectionDonneesHeader(JoinPoint joinPoint, Model model) {  
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean connecte = compteService.recupererCompteActuel() != null;
		model.addAttribute("authentified", connecte);
		if(connecte)
		{
			String nom = compteService.recupererPersonneActuel().getPersonne_nom();
			model.addAttribute("personneNom", nom);
			if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("Admin")))
				model.addAttribute("role", "Admin");
			else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("Cooperative")))
				model.addAttribute("role", "Cooperative");
			else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("User")))
				model.addAttribute("role", "User");
		}
	} 

	
}
