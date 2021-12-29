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

import com.gev.api.model.CTEkey;
import com.gev.api.model.Telechargement;
import com.gev.api.service.TelechargementService;

public class TelechargementController {
	
	@Autowired
	TelechargementService telechargementService;
	
	@GetMapping("/telechargements")
	public Iterable<Telechargement> getTelechargements(){
		return telechargementService.getTelechargements();
	}
	
	@GetMapping("/telechargement/{id}")
	public Optional<Telechargement> getTelechargement(@PathVariable CTEkey id){
		return telechargementService.getTelechargement(id);
	}
	
	@PostMapping("/saveTelechargement")
	@ResponseStatus(HttpStatus.CREATED)
	public Telechargement saveTelechargement(@Valid @RequestBody Telechargement telechargement) {
		return telechargementService.saveTelechargement(telechargement);
	}
	
	@PutMapping("/updateTelechargement")
	@ResponseStatus(HttpStatus.OK)
	public Telechargement updateTelechargement(@Valid @RequestBody Telechargement telechargement) {
		return telechargementService.saveTelechargement(telechargement);
	}
	
	@DeleteMapping("/deleteTelechargement/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteTelechargement(@PathVariable CTEkey id) {
		telechargementService.deleteTelechargement(id);
	}
	
}
