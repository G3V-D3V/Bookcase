package com.gev.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "telecharger")
@DynamicUpdate
public class Telechargement {
	
	@EmbeddedId
	private CTEkey idTelechargement;
	
	@Column(name = "h_debut")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTelechargement;
	
	@ManyToOne
    @MapsId("idLivre")
    @JoinColumn(name = "fk_livre")
	private LivreElectronique livre;
	
	@ManyToOne
    @MapsId("idEtudiant")
    @JoinColumn(name = "fk_etudiant")
	private Etudiant Etudiant;

	public Date getDateTelechargement() {
		return dateTelechargement;
	}

	public void setDateTelechargement(Date dateTelechargement) {
		this.dateTelechargement = dateTelechargement;
	}

	public CTEkey getIdTelechargement() {
		return idTelechargement;
	}

	public void setIdTelechargement(CTEkey idTelechargement) {
		this.idTelechargement = idTelechargement;
	}

	public LivreElectronique getLivre() {
		return livre;
	}

	public void setLivre(LivreElectronique livre) {
		this.livre = livre;
	}

	public Etudiant getEtudiant() {
		return Etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		Etudiant = etudiant;
	}
	
	
}
