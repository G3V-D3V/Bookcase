package com.gev.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gev.api.model.Etudiant;

@Repository
public interface EtudiantRepo extends CrudRepository<Etudiant, Short>{
	
	Etudiant findByMatricule(String matricule);
	
	List<Etudiant> findByPersonneNomLike(String nom);
	
	List<Etudiant> findByPersonnePrenomLike(String prenom);
	
	List<Etudiant> findByPersonnePaysLike(String pays);
	
}
