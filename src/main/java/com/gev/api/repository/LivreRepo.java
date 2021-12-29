package com.gev.api.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gev.api.model.Livre;

@Repository
public interface LivreRepo extends CrudRepository<Livre, Long>{

}
