package com.gev.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gev.api.model.Auteur;

@Repository
public interface AuteurRepo extends CrudRepository<Auteur, Short> {
	
	List<Auteur> findByPersonneNomLike(String nom);
	
	List<Auteur> findByPersonnePrenomLike(String prenom);
	
	List<Auteur> findByPersonnePaysLike(String pays);
	
	List<Auteur> findByProfessionLike(String profession);
}
