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
@Table(name = "emprunt")
@DynamicUpdate
public class Emprunt {
	@EmbeddedId
	private CTEkey idEmprunt;
	
	private boolean validation;
	
	private String sanction;
	
	@Column(name = "date_emprunt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEmprunt;
	
	@Column(name = "date_remise")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRemise;
	
	@ManyToOne
    @MapsId("idLivre")
    @JoinColumn(name = "fk_livre")
	private LivrePhysique livre;
	
	@ManyToOne
    @MapsId("idEtudiant")
    @JoinColumn(name = "fk_etudiant")
	private Etudiant etudiant;

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(Date dateRemise) {
		this.dateRemise = dateRemise;
	}

	public CTEkey getIdEmprunt() {
		return idEmprunt;
	}

	public void setIdEmprunt(CTEkey idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	public LivrePhysique getLivre() {
		return livre;
	}

	public void setLivre(LivrePhysique livre) {
		this.livre = livre;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;
	}
	
}
