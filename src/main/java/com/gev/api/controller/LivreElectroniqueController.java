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

import com.gev.api.model.LivreElectronique;
import com.gev.api.service.LivreElectroniqueService;

@RestController
public class LivreElectroniqueController {
	@Autowired
	LivreElectroniqueService livreElectroniqueService;
	
	@GetMapping("/livreElectroniques")
	public Iterable<LivreElectronique> getLivreElectroniques(){
		return livreElectroniqueService.getLivreElectroniques();
	}
	
	@GetMapping("/livreElectronique/{id}")
	public Optional<LivreElectronique> getLivreElectronique(@PathVariable long id){
		return livreElectroniqueService.getLivreElectronique(id);
	}
	
	@PostMapping("/saveLivreElectronique")
	@ResponseStatus(HttpStatus.CREATED)
	public LivreElectronique saveLivreElectronique(@Valid @RequestBody LivreElectronique livreElectronique) {
		return livreElectroniqueService.saveLivreElectronique(livreElectronique);
	}
	
	@PutMapping("/updateLivreElectronique")
	public LivreElectronique updateLivreElectronique(@Valid @RequestBody LivreElectronique livreElectronique) {
		return livreElectroniqueService.saveLivreElectronique(livreElectronique);
	}
	
	@DeleteMapping("/deleteEmploye/{id}")
	public void deleteLivreElectronique(@PathVariable long id) {
		livreElectroniqueService.deleteLivreElectronique(id);
	}
	
	@GetMapping("/livreElectronique/titre/{titre}")
	public List<LivreElectronique> getLivreElectroniqueByTitre(@PathVariable String titre){
		return livreElectroniqueService.searchByTitre(titre);
	}
	
	@GetMapping("/livreElectronique/domaine/{domaine}")
	public List<LivreElectronique> getLivreElectroniqueByDomaine(@PathVariable String domaine){
		return livreElectroniqueService.searchByDomaine(domaine);
	}
	
	@GetMapping("/livreElectronique/langue/{langue}")
	public List<LivreElectronique> getLivreElectroniqueByLangue(@PathVariable String langue){
		return livreElectroniqueService.searchByLangue(langue);
	}
	
	@GetMapping("/livreElectronique/search/{terme}")
	public Set<LivreElectronique> searchLivreElectronique(@PathVariable String terme) {
		return livreElectroniqueService.searchLivreElectronique(terme);
	}
}
