package com.gev.api.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gev.api.model.Auteur;
import com.gev.api.service.AuteurService;

@RestController
public class AuteurController {
	
	@Autowired
	AuteurService auteurService;
	
	@GetMapping("/auteurs")
	public Iterable<Auteur> getAuteurs(){
		return auteurService.getAuteurs();
	}
	
	@GetMapping("/auteur/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<Auteur> getAuteur(@PathVariable short id){
		return auteurService.getAuteur(id);
	}
	
	@PostMapping("/saveAuteur")
	@ResponseStatus(HttpStatus.CREATED)
	public Auteur saveAuteur(@Valid @RequestBody Auteur auteur) {
		return auteurService.saveAuteur(auteur);
	}
	
	@PostMapping("/saveAuteurs")
	@ResponseStatus(HttpStatus.CREATED)
	public Iterable<Auteur> saveAuteurs(@Valid @RequestBody Iterable<Auteur> auteurs) {
		return auteurService.saveAuteurs(auteurs);
	}
	
	@PutMapping("/updateAuteur")
	@ResponseStatus(HttpStatus.OK)
	public Auteur updateAuteur(@Valid @RequestBody Auteur auteur) {
		return auteurService.saveAuteur(auteur);
	}
	
	@DeleteMapping("/deleteAuteur/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAuteur(@PathVariable short id) {
		auteurService.deleteAuteur(id);
	}
}
