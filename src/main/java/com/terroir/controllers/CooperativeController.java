package com.terroir.controllers;

import com.terroir.dto.newProductForm;
import com.terroir.dto.updateProductForm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlleur dédié aux coopératives
 */
@RestController
@RequestMapping("/cooperative/")
public class CooperativeController {
	
	@GetMapping("suiviCommandes")
	public ModelAndView suiviCommandes() { //TODO : commandes
		
		return new ModelAndView("suiviCommandes");
	}

    @GetMapping(path = "gererProduits")
	public String getPageGestionProduits()
	{
		return "gestionProduits";
	}

	/**
	 * Passer la commande depuis "Non délivré" à "Délivré", ou vice-versa
	 * @param idCommande ID du commande
	 * @param toggle <code>True</code> signifie "Non délivré" => "Délivré" <br>
	 * <code>False</code> signifie "Délivré" => "Non délivré"
	 */
	@PostMapping("commande/toggle") 
	public void toggleCommande(int idCommande, boolean toggle) {
		//TODO
	}

	/**
     * TODO : Ajouter un nouveau produit en l'associant avec le coopérative actuel (connecté)
     */
    @PostMapping("new")
    public ResponseEntity<String> ajouterProduit(@RequestBody newProductForm form) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur");
    }

    /**
     * TODO : Modifier le produit en l'associant avec le coopérative actuel (connecté)
     */
    @PostMapping("update")
    public ResponseEntity<String> modifierProduit(@RequestBody updateProductForm form) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur");
    }

    /**
     * TODO : Ajouter un nouveau produit en l'associant avec le coopérative actuel (connecté)
     */
    @PostMapping("delete")
    public ResponseEntity<String> deleteProduit(@RequestBody int id) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur");
    }

    /**
     * Récupérer tous les produits que le coopérative actuel (connecté) possède
     * @return
     */
    @GetMapping("getAll")
    public ModelAndView getAllProduits() {
        ModelAndView model = new ModelAndView("contenu/gestionProduitsContenu");
        //TODO
        return model;
    }
}
