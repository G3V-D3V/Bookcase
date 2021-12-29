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
@Table(name = "consultation")
@DynamicUpdate
public class ConsultationBean {

	@EmbeddedId
	private CTEkey idConsultation;
	
	@Column(name = "h_debut", columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateHeureDebut;

	@Column(name = "h_fin", columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateHeureFin;
	
	@ManyToOne
	@MapsId("idLivre")
	@JoinColumn(name = "fk_livre")
	private LivrePhysique livre;

	@ManyToOne
	@MapsId("idEtudiant")
	@JoinColumn(name = "fk_etudiant")
	private Etudiant etudiant;



	public Date getDateHeureDebut() {
		return DateHeureDebut;
	}

	public void setDateHeureDebut(Date dateHeureDebut) {
		DateHeureDebut = dateHeureDebut;
	}

	public Date getDateHeureFin() {
		return DateHeureFin;
	}

	public void setDateHeureFin(Date dateHeureFin) {
		DateHeureFin = dateHeureFin;
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
}
