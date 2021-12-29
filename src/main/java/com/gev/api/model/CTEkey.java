package com.gev.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CTEkey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "fk_livre")
	private Long idLivre;
	
	@Column(name = "fk_etudiant")
	private short idEtudiant;

	public Long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Long idLivre) {
		this.idLivre = idLivre;
	}

	public short getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(short idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
}
