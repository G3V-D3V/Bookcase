package com.gev.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "livre")
@DynamicUpdate
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_livre;
	
	@Length(min = 5, max=100, message = "La longueur du titre doit être compris entre 5 et 100 !")
	private String titre;
	
	@Length(min = 5, max=50, message = "La longueur du titre doit être compris entre 5 et 100 !")
	private String domaine;
	
	@Length(min = 5, max=30, message = "La longueur du titre doit être compris entre 5 et 100 !")
	private String niveau;
	
	@Length(min = 5, max=50, message = "La longueur du titre doit être compris entre 5 et 100 !")
	private String langue;
	
	@ManyToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	@JoinTable(name = "livre_auteur", 
			joinColumns = @JoinColumn(name = "fk_livre"),
			inverseJoinColumns = @JoinColumn(name = "fk_auteur"))
	private List<Auteur> auteurs = new ArrayList<>();
	
	
	public Long getId_livre() {
		return id_livre;
	}
	public void setId_livre(Long id_livre) {
		this.id_livre = id_livre;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public List<Auteur> getAuteurs() {
		return auteurs;
	}
	public void setAuteurs(List<Auteur> auteurs2) {
		this.auteurs = auteurs2;
	}
	
}
