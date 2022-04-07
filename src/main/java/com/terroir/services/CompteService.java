package com.terroir.services;

import com.terroir.configuration.CompteDetailsServiceImpl;
import com.terroir.configuration.JwtRequest;
import com.terroir.entities.Compte;
import com.terroir.entities.Personne;
import com.terroir.entities.form.RegisterCompteForm;
import com.terroir.repositories.CompteRepo;
import com.terroir.repositories.PersonneRepo;

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
}
