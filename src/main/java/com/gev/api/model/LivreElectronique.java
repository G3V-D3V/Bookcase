package com.gev.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "livre_electronique")
@DynamicUpdate
public class LivreElectronique {
	@Id
	private Long id_livre;
	
	private String couverture;
	
	@Lob
	private byte[] contenu;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_livre", referencedColumnName = "id_livre")
	private Livre livre;

	public Long getId_livre() {
		return id_livre;
	}

	public void setId_livre(Long id_livre) {
		this.id_livre = id_livre;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public String getCouverture() {
		return couverture;
	}

	public void setCouverture(String couverture) {
		this.couverture = couverture;
	}

	public byte[] getContenu() {
		return contenu;
	}

	public void setContenu(byte[] contenu) {
		this.contenu = contenu;
	}
}
