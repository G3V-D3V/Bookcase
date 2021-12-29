package com.gev.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gev.api.model.CTEkey;
import com.gev.api.model.Telechargement;

@Repository
public interface TelecargementRepo extends CrudRepository<Telechargement, CTEkey> {
	
}
