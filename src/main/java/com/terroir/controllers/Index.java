package com.terroir.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Index {
	@GetMapping(path = "")
	public String acceuil() {
		return "Accueil"; // la methode GET retourne à la fin le nom du jsp (Acceuil.jsp)
	}
}
