package com.gev.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.api.model.Auteur;
import com.gev.api.model.Livre;
import com.gev.api.repository.LivreRepo;

@Service
public class LivreService {
	
	@Autowired
	LivreRepo livreRepo;
	
	@Autowired
	AuteurService auteurService;
	
	public Iterable<Livre> getLivres(){
		return livreRepo.findAll();
	}
	
	public Optional<Livre> getLivre(Long id){
		return livreRepo.findById(id);
	}
	
	public Livre saveLivre(Livre livre) {
		List<Auteur> auteurs = auteurService.saveAuteurs(livre.getAuteurs());
		
		livre.setAuteurs(auteurs);
		
		return livreRepo.save(livre);
	}
	
	public void deleteLivre(Long id) {
		livreRepo.deleteById(id);;
	}
}
