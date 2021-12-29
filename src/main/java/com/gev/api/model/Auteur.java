package com.gev.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "auteur")
@DynamicUpdate
public class Auteur {
	@Id
	private short id_auteur;
	
	@Length(min = 10, max = 100)
	private String profession;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_auteur", referencedColumnName = "id_personne")
	private Personne personne;

	public short getId_auteur() {
		return id_auteur;
	}

	public void setId_auteur(short id_auteur) {
		this.id_auteur = id_auteur;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}
