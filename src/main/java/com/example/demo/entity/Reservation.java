package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation {
	@Id
	private Long idReservation;
	@Column
	private long nbReservation;
	@Column
	private Date dateReservation;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	//@JoinColumn(name = "client")
	private Client client;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "affectations", joinColumns = @JoinColumn(name = "reservation"), inverseJoinColumns = @JoinColumn(name = "menu"))
	private List<Menu> menu;

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public long getNbReservation() {
		return nbReservation;
	}

	public void setNbReservation(long nbReservation) {
		this.nbReservation = nbReservation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", nbReservation=" + nbReservation + ", dateReservation="
				+ dateReservation + "]";
	}

	public Reservation(Long idReservation, Long nbReservation, Date dateReservation) {
		super();
		this.idReservation = idReservation;
		this.nbReservation = nbReservation;
		this.dateReservation = dateReservation;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
