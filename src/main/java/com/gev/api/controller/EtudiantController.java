package com.gev.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.gev.api.model.Etudiant;
import com.gev.api.service.EtudiantService;
import com.gev.api.service.PersonneService;

@RestController
public class EtudiantController {
	
	@Autowired
	EtudiantService etudiantService;
	
	@Autowired
	PersonneService personneService;
	
	@GetMapping("/etudiants")
	public Iterable<Etudiant> getEtudiants(){
		return etudiantService.getEtudiants();
	}
	
	@GetMapping("/etudiant/{id}")
	public Optional<Etudiant> getEtudiant(short id) {
		return etudiantService.getEtudiant(id);
	}
	
	@GetMapping("/etudiant/matricule/{matricule}")
	public Etudiant getEtudiantByMatricule(@PathVariable String matricule){
		return etudiantService.searchEtudiantByMatricule(matricule);
	}
	
	@GetMapping("/etudiant/nom/{nom}")
	public List<Etudiant> getEtudiantByNom(@PathVariable String nom){
		return etudiantService.searchEtudiantByNom(nom);
	}
	
	@GetMapping("/etudiant/prenom/{prenom}")
	public List<Etudiant> getEtudiantByPrenom(@PathVariable String prenom){
		return etudiantService.searchEtudiantByPrenom(prenom);
	}
	
	@GetMapping("/etudiant/pays/{pays}")
	public List<Etudiant> getEtudiantByPays(@PathVariable String pays){
		return etudiantService.searchEtudiantByPays(pays);
	}
	
	@GetMapping("/etudiant/recherche/{terme}")
	public Set<Etudiant> getEtudiantByGlobal(@PathVariable String terme){
		return etudiantService.searchEtudiant(terme);
	}
	
	@PostMapping("/saveEtudiant")
	@ResponseStatus(HttpStatus.CREATED)
	public Etudiant saveEtudiant(@Valid @RequestBody Etudiant etudiant) {
		return etudiantService.saveEtudiant(etudiant);
	}
	
	@PutMapping("/updateEtudiant")
	@ResponseStatus(HttpStatus.OK)
	public Etudiant updateEtudiant(@Valid @RequestBody Etudiant etudiant) {
		return etudiantService.saveEtudiant(etudiant);
	}
	
	@DeleteMapping("/deleteEtudiant/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEtudiant(@PathVariable short id) {
		etudiantService.deleteEtudiant(id);
	}
}
