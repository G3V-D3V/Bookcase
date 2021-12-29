package com.gev.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gev.api.model.LivrePhysique;

@Repository
public interface LivrePhysiqueRepo extends CrudRepository<LivrePhysique, Long> {
	
	LivrePhysique findByIsbn(String isbn);
	
	List<LivrePhysique> findByLivreTitreLike(String titre);
	
	List<LivrePhysique> findByLivreDomaineLike(String domaine);
	
	List<LivrePhysique> findByLivreLangueLike(String langue);
}
