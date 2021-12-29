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

import com.gev.api.Exceptions.RessourceIntrouvableException;
import com.gev.api.model.CTEkey;
import com.gev.api.model.ConsultationBean;
import com.gev.api.service.ConsultationService;

@RestController
public class ConsultationController {
	
	@Autowired
	ConsultationService consultationService;
	
	@GetMapping("/consultations")
	public Iterable<ConsultationBean> getConsultations(){
		return consultationService.getConsultations();
	}
	
	@GetMapping("/consultation/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<ConsultationBean> getConsulation(@PathVariable CTEkey id) throws RessourceIntrouvableException{
		
		Optional<ConsultationBean> consultation = consultationService.getConsultation(id);
		if (consultation == null || consultation.isEmpty()) throw new RessourceIntrouvableException("Il n'y a pas de consultation de ce genre !");
		return consultation;
	}
	
	@GetMapping("/searchConsultation/matricule/{matricule}")
	@ResponseStatus(HttpStatus.FOUND)
	public ConsultationBean getConsultationByMatriculeEtudiant(@PathVariable String matricule) {
		ConsultationBean consultation = consultationService.searchByEtudiantMatricule(matricule);
		if(consultation == null) throw new RessourceIntrouvableException("L'Etudiant de matricule "+matricule
				+" n'a pas consulté un livre !");
		
		return consultation;
	}
	
	@PostMapping("/saveConsultation")
	@ResponseStatus(HttpStatus.CREATED)
	public ConsultationBean saveConsultation(@Valid @RequestBody ConsultationBean consultation) {
		return consultationService.saveConsultation(consultation);
	}
	
	@PutMapping("/updateConsultation")
	@ResponseStatus(HttpStatus.OK)
	public ConsultationBean updateConsultation(@Valid @RequestBody ConsultationBean consultation) {
		return consultationService.saveConsultation(consultation);
	}
	
	
	@DeleteMapping("/deleteConsultation/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteConsultation(@PathVariable CTEkey id) {
		consultationService.deleteConsultation(id);
	}
}
