package com.gev.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;

@Entity
@Table(name = "personne")
@DynamicUpdate
@Getter
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id_personne;
	
	@Length(min = 3, max = 60,message = "3 caractères au minimum !")
	private String nom;
	
	@Length(min = 3, max = 60, message = "Veillez saisir au moins 3 caractères !")
	private String prenom;
	
	@Column(length = 1)
	private char sexe;
	
	@Length(min = 4, max=50)
	private String pays;

	public short getId_personne() {
		return id_personne;
	}

	public void setId_personne(short id_personne) {
		this.id_personne = id_personne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
}
