package com.gev.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gev.api.model.Personne;

@Repository
public interface PersonneRepo extends CrudRepository<Personne, Short> {

}
