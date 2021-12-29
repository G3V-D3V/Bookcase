package com.gev.api.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.api.model.Auteur;
import com.gev.api.model.Personne;
import com.gev.api.repository.AuteurRepo;

@Service
public class AuteurService {
	@Autowired
	AuteurRepo auteurRepo;
	
	@Autowired
	PersonneService personneService;

	public Iterable<Auteur> getAuteurs(){
		return auteurRepo.findAll();
	}

	public Optional<Auteur> getAuteur(short id){
		return auteurRepo.findById(id);
	}

	public Auteur saveAuteur(Auteur auteur) {
		Personne personne = personneService.savePersonne(auteur.getPersonne());
		
		auteur.setId_auteur(personne.getId_personne());
		auteur.setPersonne(personne);
		
		return auteurRepo.save(auteur);
	}
	
	public List<Auteur> saveAuteurs(Iterable<Auteur> auteurs) {
		ArrayList<Auteur> auteurOptimal = new ArrayList<>();

		for(Auteur auteur : auteurs) {
			Personne personne = personneService.savePersonne(auteur.getPersonne());
			
			auteur.setId_auteur(personne.getId_personne());
			auteur.setPersonne(personne);
			auteurOptimal.add(auteur);
		}
		
		auteurs = auteurOptimal;
		
		return (List<Auteur>) auteurRepo.saveAll(auteurs);
	}

	public void deleteAuteur(short id ) {
		auteurRepo.deleteById(id);
	}

	public List<Auteur> searchAuteurByNom(String nom){
		return auteurRepo.findByPersonneNomLike(nom);
	}

	public List<Auteur> searchAuteurByPrenom(String prenom){
		return auteurRepo.findByPersonnePrenomLike(prenom);
	}

	public List<Auteur> searchAuteurByPays(String pays){
		return auteurRepo.findByPersonnePaysLike(pays);
	}

	public List<Auteur> searchAuteurByProfession(String profession){
		return auteurRepo.findByProfessionLike(profession);
	}

	public Set<Auteur> searchAuteur(String termeDeRecherche) {
		Set<Auteur> listAuteurs = new HashSet<Auteur>();

		List<Auteur> listNom    = searchAuteurByNom(termeDeRecherche);
		List<Auteur> listPrenom = searchAuteurByPrenom(termeDeRecherche);
		List<Auteur> listPays   = searchAuteurByPays(termeDeRecherche);

		if(listNom != null) listAuteurs.addAll(listNom);
		if(listPrenom != null) listAuteurs.addAll(listPrenom);
		if(listPays != null) listAuteurs.addAll(listPays);
		return listAuteurs;
	}
}
