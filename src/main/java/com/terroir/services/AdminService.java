package com.terroir.services;

import java.util.ArrayList;
import java.util.List;

import com.terroir.entities.Cooperative;
import com.terroir.entities.DemandeCooperative;
import com.terroir.entities.MatierePremiere;
import com.terroir.entities.Origine;
import com.terroir.repositories.CooperativeRepo;
import com.terroir.repositories.DemandeCoopRepo;
import com.terroir.repositories.MatiereRepo;
import com.terroir.repositories.OrigineRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired CooperativeRepo cooperativeRepo;
	@Autowired DemandeCoopRepo demandeCoopRepo;
	@Autowired MatiereRepo matiereRepo;
	@Autowired OrigineRepo origineRepo;

	/**
	 * Approuver (ou non) les demandes d'être coopérative
	 * @param idCooperative ID du coopérative
	 * @param isAccepted Si <code>False</code>, la demande va être supprimée
	 */
	public void gererDemandeCoop(int idCooperative, boolean isAccepted)
	{
		try {
			Cooperative c = cooperativeRepo.findById(idCooperative).get();
			DemandeCooperative dc = c.getDemandeCooperative();
			if(isAccepted)
			{
				dc.setDemande_approuvee(true);
				demandeCoopRepo.save(dc);
			}
			else
			{
				demandeCoopRepo.delete(dc);
			}
		} catch (Exception e) {
			//SI le coopérative n'existe pas, donc rien à faire
		}
	}

	/**
	 * Récuperer les demandes coopératives non encore approuvés
	 */
	public List<DemandeCooperative> getDemandeCooperatives()
	{
		List<DemandeCooperative> dcs = new ArrayList<>();
		for (DemandeCooperative dc : demandeCoopRepo.findAll()) {
			if(!dc.isDemande_approuvee())
				dcs.add(dc);
		} 

		return dcs;
	}

	public List<MatierePremiere> getAllMatierePremieres()
	{
		return matiereRepo.findAll();
	}

	/**
	 * AJouter une nouvelle matière première au BD
	 * @param nom le nom du matière première
	 */
	public void creerMatierePremiere(String nom)
	{
		MatierePremiere mp = new MatierePremiere();
		mp.setMatiere_premiere_nom(nom);
		matiereRepo.save(mp);
	}

	public List<Origine> getAllOrigines()
	{
		return origineRepo.findAll();
	}

	public void creerOrigine(String nom)
	{
		Origine o = new Origine();
		o.setOrigine_nom(nom);
		origineRepo.save(o);
	}
}
