package com.gev.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.api.model.Personne;
import com.gev.api.repository.PersonneRepo;

@Service
public class PersonneService {
	
	@Autowired
	PersonneRepo personneRepo;
	
	public Iterable<Personne> getPersonnes(){
		return personneRepo.findAll();
	}
	
	public Optional<Personne> getPersonne(short id){
		return personneRepo.findById(id);
	}
	
	public Personne savePersonne(Personne personne) {
		return personneRepo.save(personne);
	}
	
	public void deletePersonne(short id) {
		personneRepo.deleteById(id);
	}

}
