package com.gev.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.api.model.Livre;
import com.gev.api.model.LivrePhysique;
import com.gev.api.repository.LivrePhysiqueRepo;

@Service
public class LivrePhysiqueService {
	

	@Autowired
	LivrePhysiqueRepo livrePhiysiqueRepo;
	
	@Autowired
	LivreService livreservice;

	public Iterable<LivrePhysique> getLivrePhysiques(){
		return livrePhiysiqueRepo.findAll();
	}
	
	public Optional<LivrePhysique> getLivrePhysique(long id){
		return livrePhiysiqueRepo.findById(id);
	}
	
	public LivrePhysique saveLivrePhysique(LivrePhysique livrePhiysique) {
		Livre livre = livreservice.saveLivre(livrePhiysique.getLivre());
		
		livrePhiysique.setId_livre(livre.getId_livre());
		livrePhiysique.setLivre(livre);
		
		return livrePhiysiqueRepo.save(livrePhiysique);
	}
	
	public void deleteLivrePhysique(long id) {
		livrePhiysiqueRepo.deleteById(id);
	}
	
	public LivrePhysique searchByIsbn(String isbn) {
		return livrePhiysiqueRepo.findByIsbn(isbn);
	}
	
	public List<LivrePhysique> searchByTitre(String titre){
		return livrePhiysiqueRepo.findByLivreTitreLike(titre);
	}
	
	public List<LivrePhysique> searchByDomaine(String domaine){
		return livrePhiysiqueRepo.findByLivreDomaineLike(domaine);
	}
	
	public List<LivrePhysique> searchByLangue(String langue){
		return livrePhiysiqueRepo.findByLivreLangueLike(langue);
	}
	
	public Set<LivrePhysique> searchLivrePhysique(String termeDeRecherche) {
		Set<LivrePhysique> listLivrePhysiques = new HashSet<LivrePhysique>();

		List<LivrePhysique> listTitre    = searchByTitre(termeDeRecherche+"%");
		List<LivrePhysique> listDomaine  = searchByDomaine(termeDeRecherche+"%");
		List<LivrePhysique> listLangue   = searchByLangue(termeDeRecherche+"%");
		LivrePhysique livrePhysique      = searchByIsbn( termeDeRecherche);

		if(listTitre != null) listLivrePhysiques.addAll(listTitre);
		if(listDomaine != null) listLivrePhysiques.addAll(listDomaine);
		if(listLangue != null) listLivrePhysiques.addAll(listLangue);
		if(livrePhysique != null) listLivrePhysiques.add(livrePhysique);
		
		return listLivrePhysiques;
	}

	
}
