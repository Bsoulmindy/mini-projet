package com.terroir.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.terroir.entities.MatierePremiere;
import com.terroir.entities.Origine;
import com.terroir.repositories.MatiereRepo;
import com.terroir.repositories.OrigineRepo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 

@Aspect
@Component
public class SortedProductsAspect {
	@Autowired MatiereRepo matiereRepo;
	@Autowired OrigineRepo origineRepo;

	Logger log = LogManager.getLogger(SortedProductsAspect.class);
	
	/**
	 * Journaliser les catégories demandés
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Before("execution(* *..ProduitsController.getProduitsOfCategory(..)) and args(category, ..)")
	public void ByCategory(JoinPoint jp, String category) throws Throwable {
		log.info("Catégorie : " + category);
	}

	@Before("execution(* *..ProduitsController.getProduitsOfMatierePremiere(..)) and args(matierePremiere, ..)")
	public void ByMatierePremiere(JoinPoint jp, int matierePremiere) throws Throwable {
		MatierePremiere mp =  matiereRepo.findById(matierePremiere).get();
		log.info("Matière Première : " + mp.getMatiere_premiere_nom());
	}

	@Before("execution(* *..ProduitsController.getProduitsOfOrigine(..)) and args(origine, ..)")
	public void ByOrigine(JoinPoint jp, int origine) throws Throwable {
		Origine o =  origineRepo.findById(origine).get();
		log.info("Origine : " + o.getOrigine_nom());
	}

}
