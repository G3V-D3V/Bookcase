package com.gev.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "livre_physique")
@DynamicUpdate
public class LivrePhysique implements Serializable {
	
	@Id
	private Long id_livre;
	
	private static final long serialVersionUID = 1L;
	
	private String position;
	
	@Length(min = 13, max = 15, message="Ce ISBN est invalide, il doit contenir entre 13 à 15 carctères !")
	private String isbn;
	
	private Integer examplaire;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_livre", referencedColumnName = "id_livre")
	private Livre livre;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getExamplaire() {
		return examplaire;
	}

	public void setExamplaire(Integer i) {
		this.examplaire = i;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Long getId_livre() {
		return id_livre;
	}

	public void setId_livre(Long id_livre) {
		this.id_livre = id_livre;
	}
}
