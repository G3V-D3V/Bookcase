package com.gev.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.api.model.Etudiant;
import com.gev.api.model.Personne;
import com.gev.api.repository.EtudiantRepo;

@Service
public class EtudiantService {

	@Autowired
	EtudiantRepo etudiantRepo;
	
	@Autowired
	PersonneService personneService;

	public Iterable<Etudiant> getEtudiants() {
		return etudiantRepo.findAll();
	}

	public Optional<Etudiant> getEtudiant(short id){
		return etudiantRepo.findById(id);
	}

	public Etudiant saveEtudiant(Etudiant etudiant) {
		Personne personne = personneService.savePersonne(etudiant.getPersonne());
		etudiant.getPersonne().setId_personne(personne.getId_personne());
		etudiant.setId_etudiant(personne.getId_personne());
		return etudiantRepo.save(etudiant);
	}

	public void deleteEtudiant(short id) {
		etudiantRepo.deleteById(id);
	}

	public Etudiant searchEtudiantByMatricule(String matricule) {
		return etudiantRepo.findByMatricule(matricule);
	}
	
	public List<Etudiant> searchEtudiantByNom(String nom){
		return etudiantRepo.findByPersonneNomLike(nom);
	}

	public List<Etudiant> searchEtudiantByPrenom(String prenom){
		return etudiantRepo.findByPersonnePrenomLike(prenom);
	}

	public List<Etudiant> searchEtudiantByPays(String pays){
		return etudiantRepo.findByPersonnePaysLike(pays);
	}

	public Set<Etudiant> searchEtudiant(String termeDeRecherche) {
		Set<Etudiant> listEtudiants = new HashSet<Etudiant>();
		List<Etudiant> listNom    = searchEtudiantByNom(termeDeRecherche);
		List<Etudiant> listPrenom = searchEtudiantByPrenom(termeDeRecherche);
		List<Etudiant> listPays   = searchEtudiantByPays(termeDeRecherche);

		if(listNom != null) listEtudiants.addAll(listNom);
		if(listPrenom != null) listEtudiants.addAll(listPrenom);
		if(listPays != null) listEtudiants.addAll(listPays);

		return listEtudiants;
	}

}
