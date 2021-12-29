package com.gev.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gev.api.model.CTEkey;
import com.gev.api.model.ConsultationBean;

@Repository
public interface ConsultationRepo extends CrudRepository<ConsultationBean, CTEkey> {
	ConsultationBean findByEtudiantMatricule(String matricule);
}
