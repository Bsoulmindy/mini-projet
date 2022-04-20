package com.terroir.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import com.terroir.configuration.CompteDetailsServiceImpl;
import com.terroir.configuration.JwtRequest;
import com.terroir.entities.Commande;
import com.terroir.entities.CommandeProduitAsso;
import com.terroir.entities.CommandeProduitKey;
import com.terroir.entities.Compte;
import com.terroir.entities.Personne;
import com.terroir.entities.Produit;
import com.terroir.entities.form.RegisterCompteForm;
import com.terroir.repositories.CommandeProduitAssoRepo;
import com.terroir.repositories.CommandeRepo;
import com.terroir.repositories.CompteRepo;
import com.terroir.repositories.PersonneRepo;
import com.terroir.repositories.ProduitRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompteService {
	@Autowired CompteRepo compteRepo;
	@Autowired PersonneRepo personneRepo;
    @Autowired ProduitRepo produitRepo;
    @Autowired CommandeRepo commandeRepo;
    @Autowired CommandeProduitAssoRepo commandeProduitAssoRepo;
	@Autowired PasswordEncoder passwordEncoder;
    @Autowired CompteDetailsServiceImpl compteDetailsService;
    @Autowired AuthenticationManager authenticationManager;
	

	public boolean creerCompte(RegisterCompteForm compteForm, boolean isAdmin)
    	{
        Compte compte = new Compte();
        compte.setCompte_username(compteForm.getUsername());
        compte.setCompte_password(passwordEncoder.encode(compteForm.getPassword()));
	    compte.setAdmin(isAdmin);


            Personne personne = new Personne();
            personne.setPersonne_nom(compteForm.getNom());

            try
            {
                compte = compteRepo.save(compte);
            }
            catch(Exception e)
            {
		    e.printStackTrace();
                return false;
            }

            try
            {
                compte.setPersonne(personne);
                personne.setCompte(compte);
                personne = personneRepo.save(personne);
            }
            catch(Exception e)
            {
		e.printStackTrace();
                compteRepo.deleteById(compte.getCompte_id());
                return false;
            }
        
        return true;
    }

    /**
     * Connecter au compte en utilisant Username & Password
     * @param form : doit contenir le champ <code>username</code> et <code>password</code>
     * @return <code>True</code> si la connexion a été fait avec succès, <code>False</code> sinon
     */
    public boolean connecterAvecUsername(JwtRequest form) 
    {
        String username = form.getUsername();
        String password = form.getPassword();
        UserDetails userDetails = compteDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            return true;
        }
        return false;
    }

    /**
     * Recuperer <code>Compte</code> connecté
     * @return <code>Compte</code> si vous êtes connecté, <code>null</code> sinon
     */
    public Compte recupererCompteActuel() {
        Compte compte = null;
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails instanceof UserDetails) {
            String username = ((UserDetails)userDetails).getUsername();
            compte = compteRepo.getByUsername(username);
        }
        return compte;
    }

    public Personne recupererPersonneActuel() {
        return recupererCompteActuel().getPersonne();
    }

    /**
     * Recuperer les commandes de l'utilisateur actuel
     */
    public List<Commande> getAllCommandesOfUser()
    {
        return recupererCompteActuel().getCommandes();
    }

    /**
     * Acheter en se basant sur les cookies
     * @param cookies = {idProduit , Qté}
     */
    public void acheter(Cookie[] cookies)
    {
        Commande commande = new Commande();
        commande.setCommande_is_delivre(false);
        float prixTotal = 0;
        List<CommandeProduitAsso> assos = new ArrayList<>();

        for (Cookie cookie : cookies) {
            try {
                Produit p = produitRepo.findById(Integer.valueOf(cookie.getName())).get();
                prixTotal += p.getProduit_prix() * Integer.valueOf(cookie.getValue());
                CommandeProduitAsso asso = new CommandeProduitAsso();
                asso.setCommande(commande);
                asso.setProduit(p);
                asso.setQuantite(Integer.valueOf(cookie.getValue()));

                assos.add(asso);
            } catch (Exception e) {
                continue; //Rien à faire si le cookie correspond à autre chose comme Session par example
            }
        }

        commande.setCommande_prix_total(prixTotal);
        commande.setCompte(recupererCompteActuel());

        commande = commandeRepo.save(commande);

        for (CommandeProduitAsso asso : assos) {
            CommandeProduitKey key = new CommandeProduitKey(asso.getProduit().getProduit_id(), commande.getCommande_id());

            asso.setIdref(key);

            commandeProduitAssoRepo.save(asso);
        }
    }
}
