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

import com.gev.api.model.LivrePhysique;
import com.gev.api.service.LivrePhysiqueService;

@RestController

public class LivrePhysiqueContoller {
	
	@Autowired
	LivrePhysiqueService livrephysiqueService;
	
	@GetMapping("/livrePhysiques")
	public Iterable<LivrePhysique> getLivrePhysiques(){
		return livrephysiqueService.getLivrePhysiques();
	}
	
	@GetMapping("/livrePhysique/{id}")
	public Optional<LivrePhysique> getLivrePhysiques(@PathVariable long id){
		return livrephysiqueService.getLivrePhysique(id);
	}
	
	@PostMapping("/saveLivrePhysique")
	@ResponseStatus(HttpStatus.CREATED)
	public LivrePhysique saveLivrePhysique(@RequestBody LivrePhysique livrePhysique) {
		return livrephysiqueService.saveLivrePhysique(livrePhysique);
	}
	
	@PutMapping("/updateLivrePhysique")
	@ResponseStatus(HttpStatus.OK)
	public LivrePhysique updateLivrePhysique(@Valid @RequestBody LivrePhysique livrePhysique) {
		return livrephysiqueService.saveLivrePhysique(livrePhysique);
	}
	
	@DeleteMapping("/deleteLivrePhysique/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteLivrePhysique(@PathVariable long id) {
		livrephysiqueService.deleteLivrePhysique(id);
	}
	
	@GetMapping("/livrePhysique/titre/{titre}")
	public List<LivrePhysique> getLivrePhysiqueiqueByTitre(@PathVariable String titre){
		return livrephysiqueService.searchByTitre(titre);
	}
	
	@GetMapping("/livrePhysique/domaine/{domaine}")
	public List<LivrePhysique> getLivrePhysiqueByDomaine(@PathVariable String domaine){
		return livrephysiqueService.searchByDomaine(domaine);
	}
	
	@GetMapping("/livrePhysique/isbn/{isbn}")
	public LivrePhysique getLivrePhysiqueByISBN(@PathVariable String isbn){
		return livrephysiqueService.searchByIsbn(isbn);
	}
	
	@GetMapping("/livrePhysique/langue/{langue}")
	public List<LivrePhysique> getLivrePhysiqueByLangue(@PathVariable String langue){
		return livrephysiqueService.searchByLangue(langue);
	}
	
	@GetMapping("/livrePhysique/search/{terme}")
	public Set<LivrePhysique> searchLivrePhysique(@PathVariable String terme) {
		return livrephysiqueService.searchLivrePhysique(terme);
	}
}
