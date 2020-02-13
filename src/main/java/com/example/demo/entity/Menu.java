package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Menu {
	@Id
	private Long idMenu;
	@Column
	private String nomMenu;
	@Column
	private double prixMenu;

	@ManyToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Reservation> reservation;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "menu", orphanRemoval = true)
	private List<Plat> plat = new ArrayList<Plat>();

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public String getNomMenu() {
		return nomMenu;
	}

	public void setNomMenu(String nomMenu) {
		this.nomMenu = nomMenu;
	}

	public double getPrixMenu() {
		return prixMenu;
	}

	public void setPrixMenu(double prixMenu) {
		this.prixMenu = prixMenu;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public List<Plat> getPlat() {
		return plat;
	}

	public void setPlat(List<Plat> plat) {
		this.plat = plat;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Menu [nomMenu=" + nomMenu + "]";
	}

	public Menu(Long idMenu, String nomMenu, double prixMenu, List<Plat> plat) {
		super();
		this.idMenu = idMenu;
		this.nomMenu = nomMenu;
		this.prixMenu = prixMenu;
		this.plat = plat;
	}

}
