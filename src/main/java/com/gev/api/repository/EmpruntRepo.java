package com.gev.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gev.api.model.CTEkey;
import com.gev.api.model.Emprunt;

public interface EmpruntRepo extends CrudRepository<Emprunt, CTEkey> {
	
	List<Emprunt> findByEtudiantPersonneNomLike(String nom);
	
	Emprunt findByEtudiantMatricule(String matricule);	
}
