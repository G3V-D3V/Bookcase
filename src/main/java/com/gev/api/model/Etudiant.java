package com.gev.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "etudiant")
@DynamicUpdate
public class Etudiant {
	@Id
	private short id_etudiant;
	
	@Column(length = 9)
	private String matricule;
	
	@Length(min = 5, max=50)
	private String niveau;
	
	@Column(name = "mot_de_passe")
	private String motDePasse;
	
	@Column(name = "peut_emprunter")
	private boolean peutEmprunter;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_etudiant", referencedColumnName = "id_personne")
	private Personne personne;

	public short getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(short id_etudiant) {
		this.id_etudiant = id_etudiant;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Boolean getPeutEmprunter() {
		return peutEmprunter;
	}

	public void setPeutEmprunter(Boolean peutEmprunter) {
		this.peutEmprunter = peutEmprunter;
	}
}
