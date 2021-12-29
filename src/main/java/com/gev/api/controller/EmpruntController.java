package com.gev.api.controller;

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

import com.gev.api.Exceptions.RessourceIntrouvableException;
import com.gev.api.model.CTEkey;
import com.gev.api.model.Emprunt;
import com.gev.api.model.LivrePhysique;
import com.gev.api.service.EmpruntService;

@RestController
public class EmpruntController {

	@Autowired
	EmpruntService empruntService;

	@GetMapping("/emprunts")
	public Iterable<Emprunt> getEmprunts(){
		return empruntService.getEmprunts();
	}

	@GetMapping("/emprunt/{matricule}")
	@ResponseStatus(HttpStatus.FOUND)
	public Emprunt getEmprunt(@PathVariable String matricule) throws RessourceIntrouvableException {

		Emprunt emprunt = empruntService.getEmprunt(matricule);
		if(emprunt == null ) throw new RessourceIntrouvableException("Le matricule "+matricule+" n'a pas emprunté un livre !");
		return emprunt;
	}

	@PostMapping("/saveEmprunt")
	@ResponseStatus(HttpStatus.CREATED)
	public Emprunt saveEmprunt(@Valid @RequestBody Emprunt emprunt) {

		LivrePhysique livre = emprunt.getLivre();
		livre.setExamplaire(emprunt.getLivre().getExamplaire() - 1);
		emprunt.setLivre(livre);
		emprunt.getEtudiant().setPeutEmprunter(false);

		return empruntService.saveEmprunt(emprunt);
	}

	@PutMapping("/updateEmprunt")
	@ResponseStatus(HttpStatus.OK)
	public Emprunt updateEmprunt(@Valid @RequestBody Emprunt emprunt) {
		return empruntService.saveEmprunt(emprunt);
	}

	@PutMapping("/remiseLivreEmprunte")
	@ResponseStatus(HttpStatus.OK)
	public Emprunt remiseLivreEmprunte(@Valid @RequestBody Emprunt emprunt) {

		if(emprunt.getDateRemise() != null) {
			LivrePhysique livre = emprunt.getLivre();
			livre.setExamplaire(emprunt.getLivre().getExamplaire().intValue() + 1);
			emprunt.setLivre(livre);
		}

		return empruntService.saveEmprunt(emprunt);
	}

	@DeleteMapping("/deleteEmprunt/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmprunt(@PathVariable CTEkey id) {
		empruntService.deleteEmprunt(id);
	}
}
