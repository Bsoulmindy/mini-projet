package com.terroir.controllers;

import com.terroir.services.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/category/")
public class CategoryController {
	@Autowired ProduitService produitService;

	@GetMapping("get/all")
	public ModelAndView getProduits(Model model) {
		model.addAttribute("products", produitService.getAllProduits());

		ModelAndView modelAndView = new ModelAndView();
        	modelAndView.setViewName("products");
        	return modelAndView;
	}
	
	@GetMapping("get/category")
	public ModelAndView getProduitsOfCategory(@RequestParam("categorie") String category, Model model) {
		model.addAttribute("products", produitService.getAllProduitsOfCategory(category));

		ModelAndView modelAndView = new ModelAndView();
        	modelAndView.setViewName("products");
        	return modelAndView;
	}

	@GetMapping("get/matierePremiere")
	public ModelAndView getProduitsOfMatierePremiere(@RequestParam("matierePremiere") int matierePremiere, Model model) {
		model.addAttribute("products", produitService.getAllProduitsOfMatierePremiere(matierePremiere));

		ModelAndView modelAndView = new ModelAndView();
        	modelAndView.setViewName("products");
        	return modelAndView;
	}

	@GetMapping("get/origine")
	public ModelAndView getProduitsOfOrigine(@RequestParam("origine") int origine, Model model) {
		model.addAttribute("products", produitService.getAllProduitsOfOrigine(origine));

		ModelAndView modelAndView = new ModelAndView();
        	modelAndView.setViewName("products");
        	return modelAndView;
	}
}
