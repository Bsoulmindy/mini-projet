package com.terroir.controllers;

import com.terroir.dto.newProductForm;
import com.terroir.dto.updateProductForm;
import com.terroir.exception.FormException;
import com.terroir.services.CooperativeService;
import com.terroir.services.MatierePremiereServie;
import com.terroir.services.OrigineService;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired CooperativeService cooperativeService;
    @Autowired MatierePremiereServie matierePremiereServie;
    @Autowired OrigineService origineService;
	
	@GetMapping("suiviCommandes")
	public ModelAndView suiviCommandes() {
		ModelAndView model = new ModelAndView("suiviCommandes");
        model.addObject("commandes", cooperativeService.getCommandesOfCooperative());
		return model;
	}

    /**
     * Formulaire afin d'ajouter, modifier ou supprimer un produit
     */
    @GetMapping(path = "gererProduits")
	public ModelAndView getPageGestionProduits()
	{
        ModelAndView model = new ModelAndView("gestionProduits");
        model.addObject("products", cooperativeService.getProduitsOfCooperative());
        model.addObject("matierePremieres", matierePremiereServie.getAllMatierePremieres());
        model.addObject("origines", origineService.getAlOrigines());
		return model;
	}

	/**
	 * Passer la commande depuis "Non délivré" à "Délivré", ou vice-versa
	 * @param idCommande ID du commande
	 * @param toggle <code>True</code> signifie "Non délivré" => "Délivré" <br>
	 * <code>False</code> signifie "Délivré" => "Non délivré"
	 */
	@PostMapping("commande/toggle") 
	public void toggleCommande(int idCommande, boolean toggle) {
		cooperativeService.toggleCommande(idCommande, toggle);
	}

	/**
     * Ajouter un nouveau produit en l'associant avec le coopérative actuel (connecté)
     */
    @PostMapping("produit/new")
    public ResponseEntity<String> ajouterProduit(@RequestBody newProductForm form) {
        
        try {
            cooperativeService.ajouterProduit(form);
        } catch (FormException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.OK).body("Produit ajouté!");
    }

    /**
     * Modifier le produit en changement seulement les attributs indiqués
     */
    @PostMapping("produit/update")
    public ResponseEntity<String> modifierProduit(@RequestBody updateProductForm form) {

        try {
            cooperativeService.updateProduit(form);
        } catch (FormException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.OK).body("Produit modifié!");
    }

    /**
     * Supprimer le produit
     */
    @PostMapping("produit/delete")
    public ResponseEntity<String> deleteProduit(@RequestBody int id) {
        try {
            cooperativeService.deleteProduit(id);
        } catch (FormException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.OK).body("Produit supprimé!");
    }

    /**
     * Associer le produit
     */
    @PostMapping("produit/associate")
    public ResponseEntity<String> associerProduit(int idProduit, int idMatierePremiere, int idOrigine) {
        try {
            cooperativeService.associerProduit(idProduit, idMatierePremiere, idOrigine);
        } catch (FormException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Produit associé!");
    }

    /**
     * Récupérer tous les produits que le coopérative actuel (connecté) possède
     * @return
     */
    @GetMapping("produit/getAll")
    public ModelAndView getAllProduits() {
        ModelAndView model = new ModelAndView("contenu/gestionProduitsContenu");
        model.addObject("products", cooperativeService.getProduitsOfCooperative());
        return model;
    }
}
