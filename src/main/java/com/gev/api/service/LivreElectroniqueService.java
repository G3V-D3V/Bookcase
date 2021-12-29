package com.gev.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.api.model.LivreElectronique;
import com.gev.api.repository.LivreElectroniqueRepo;

@Service
public class LivreElectroniqueService {
	
	@Autowired
	LivreElectroniqueRepo livreElectroniqueRepo;
	
	public Iterable<LivreElectronique> getLivreElectroniques(){
		return livreElectroniqueRepo.findAll();
	}
	
	public Optional<LivreElectronique> getLivreElectronique(long id){
		return livreElectroniqueRepo.findById(id);
	}
	
	public LivreElectronique saveLivreElectronique(LivreElectronique livreElectronique) {
		return livreElectroniqueRepo.save(livreElectronique);
	}
	
	public void deleteLivreElectronique(long id) {
		livreElectroniqueRepo.deleteById(id);
	}
	
	public List<LivreElectronique> searchByTitre(String titre){
		return livreElectroniqueRepo.findByLivreTitreLike(titre);
	}
	
	public List<LivreElectronique> searchByDomaine(String domaine){
		return livreElectroniqueRepo.findByLivreDomaineLike(domaine);
	}
	
	public List<LivreElectronique> searchByLangue(String langue){
		return livreElectroniqueRepo.findByLivreLangueLike(langue);
	}
	
//	public List<LivreElectronique> searchByNomAuteur(String auteur){
//		return livreElectroniqueRepo.findByAuteurPersonneNomLike(auteur);
//	}
	
	public Set<LivreElectronique> searchLivreElectronique(String termeDeRecherche) {
		Set<LivreElectronique> listLivreElectroniques = new HashSet<LivreElectronique>();

		List<LivreElectronique> listTitre    = searchByTitre(termeDeRecherche+"%");
		List<LivreElectronique> listDomaine = searchByDomaine(termeDeRecherche+"%");
		List<LivreElectronique> listLangue = searchByLangue(termeDeRecherche+"%");
//		List<LivreElectronique> listPays   = searchByNomAuteur(termeDeRecherche);

		if(listTitre != null) listLivreElectroniques.addAll(listTitre);
		if(listDomaine != null) listLivreElectroniques.addAll(listDomaine);
		if(listLangue != null) listLivreElectroniques.addAll(listLangue);
//		if(listPays != null) listLivreElectroniques.addAll(listPays);
		return listLivreElectroniques;
	}
	
}
