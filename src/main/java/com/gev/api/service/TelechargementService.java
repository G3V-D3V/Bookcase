package com.gev.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.api.model.CTEkey;
import com.gev.api.model.Telechargement;
import com.gev.api.repository.TelecargementRepo;

@Service
public class TelechargementService {
	@Autowired
	TelecargementRepo telechargementRepo;
	
	public Iterable<Telechargement> getTelechargements(){
		return telechargementRepo.findAll();
	}
	
	public Optional<Telechargement> getTelechargement(CTEkey id){
		return telechargementRepo.findById(id);
	}
	
	public Telechargement saveTelechargement(Telechargement telechargement) {
		return telechargementRepo.save(telechargement);
	}
	
	public void deleteTelechargement(CTEkey id) {
		telechargementRepo.deleteById(id);
	}

}
