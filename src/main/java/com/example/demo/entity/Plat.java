package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Plat {
	@Id
	private Long idPlat;
	@Column
	private String nomPlat;
	@Column
	private boolean vegan;
	@Column
	private double prixPlat;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "menu")
	private Menu menu;

	public Long getIdPlat() {
		return idPlat;
	}

	public void setIdPlat(Long idPlat) {
		this.idPlat = idPlat;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public String getNomPlat() {
		return nomPlat;
	}

	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}

	public double getPrixPlat() {
		return prixPlat;
	}

	public void setPrixPlat(double prixPlat) {
		this.prixPlat = prixPlat;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Plat(Long idPlat, String nomPlat, boolean vegan, double prixPlat) {
		super();
		this.idPlat = idPlat;
		this.nomPlat = nomPlat;
		this.vegan = vegan;
		this.prixPlat = prixPlat;
	}

	@Override
	public String toString() {
		return "Plat [nomPlat=" + nomPlat + "]";
	}

	public Plat() {
		super();
		// TODO Auto-generated constructor stub
	}

}
