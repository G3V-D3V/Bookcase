package com.gev.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gev.api.model.LivreElectronique;

@Repository
public interface LivreElectroniqueRepo extends CrudRepository<LivreElectronique, Long> {
	
	List<LivreElectronique> findByLivreTitreLike(String titre);
	
	List<LivreElectronique> findByLivreDomaineLike(String domaine);
	
	List<LivreElectronique> findByLivreLangueLike(String langue);
	
//	List<LivreElectronique> findByLivreAuteursPersonneNomLike(String titre);
}
