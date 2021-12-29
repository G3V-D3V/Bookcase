package com.gev.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.api.model.CTEkey;
import com.gev.api.model.Emprunt;
import com.gev.api.repository.EmpruntRepo;

@Service
public class EmpruntService {
	
	@Autowired
	EmpruntRepo empruntRepo;
	
	@Autowired
	EtudiantService edutiantService;
	
	@Autowired
	LivrePhysiqueService livrePhysiqueService;
	
	public Iterable<Emprunt> getEmprunts(){
		return empruntRepo.findAll();
	}
	
	public Emprunt getEmprunt(String matricule){
		return empruntRepo.findByEtudiantMatricule(matricule);
	}
	
	public Emprunt saveEmprunt(Emprunt emprunt) {
		return empruntRepo.save(emprunt);
	}
	
	public void deleteEmprunt(CTEkey id) {
		empruntRepo.deleteById(id);
	}
	
	public List<Emprunt> searchByNomEmprunteur(String nom) {
		return empruntRepo.findByEtudiantPersonneNomLike(nom);
	}
	
	public Emprunt searchbyMatriculeEmprunteur(String matricule){
		return empruntRepo.findByEtudiantMatricule(matricule);
	}
}
