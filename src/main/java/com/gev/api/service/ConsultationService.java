package com.gev.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.api.model.CTEkey;
import com.gev.api.model.ConsultationBean;
import com.gev.api.repository.ConsultationRepo;

@Service
public class ConsultationService {
	
	@Autowired
	ConsultationRepo consultationRepo;
	
	public Iterable<ConsultationBean> getConsultations() {
		return consultationRepo.findAll();
	}
	
	public Optional<ConsultationBean> getConsultation(CTEkey id){
		return consultationRepo.findById(id);
	}
	
	public ConsultationBean saveConsultation(ConsultationBean consultation) {
		return consultationRepo.save(consultation);
	}
	
	public void deleteConsultation(CTEkey id) {
		consultationRepo.deleteById(id);
	}
	
	public ConsultationBean searchByEtudiantMatricule(String matrincule) {
		return consultationRepo.findByEtudiantMatricule(matrincule);
	}
}
