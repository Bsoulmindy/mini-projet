package com.terroir.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/achat/")
public class Achat {
	@GetMapping(path = "")
	public String achat() { return "Accueil"; } //TODO : Cookies = {idProduit , Qté}
}
