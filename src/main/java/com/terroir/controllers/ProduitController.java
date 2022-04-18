package com.terroir.controllers;


import com.terroir.services.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {
    
    @Autowired
	ProduitService produitService;

	// @RequestMapping("/produits/")
	// public Produit getProduit(@PathVariable("id") int id){
    //     return produitService.getProduit(id);
    // }
 
    // public List<Integer> getProduiPartMatP(@RequestParam("idmatps")int...idmatps){
    //     return produitService.getListProduitsParMatiers(idmatps);
    // }
 
    // public List<Integer> getProduitParOrigine(@RequestParam("idorigine")int idorigine){
    //     return produitService.getListProduitsParOrigine(idorigine);
    // }
 
    // public List<Integer> getProduitParCat(@RequestParam("idcat")int idcat){
    //     return produitService.getListProduitsParCat(idcat);
    // }


}
