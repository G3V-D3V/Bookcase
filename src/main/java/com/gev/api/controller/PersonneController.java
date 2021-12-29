package com.gev.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gev.api.model.Personne;
import com.gev.api.service.PersonneService;

@RestController
public class PersonneController {
	
	@Autowired
	PersonneService personneService;
	
	@PostMapping("/savePersonne")
	@ResponseStatus(HttpStatus.CREATED)
	public Personne savePersonne(@Valid @RequestBody Personne personne) {
		return personneService.savePersonne(personne);
	}
	
}
