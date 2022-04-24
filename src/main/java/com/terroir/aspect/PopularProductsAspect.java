package com.terroir.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.terroir.entities.Produit;
import com.terroir.services.ProduitService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 

@Aspect
@Component
public class PopularProductsAspect {
	@Autowired ProduitService produitService;

	Logger log = LogManager.getLogger(SortedProductsAspect.class);
	
	/**
	 * Journaliser les produits consultés
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Before("execution(* *..IndexController.produit(..)) and args(.., produit_id)")
	public void produitsConsulte(JoinPoint jp, int produit_id) throws Throwable {
		Produit produit = produitService.getProduitID(produit_id);
		log.info(produit.getProduit_nom());
	}



}
