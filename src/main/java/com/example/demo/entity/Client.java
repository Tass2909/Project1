package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "client")
@Table(name = "client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {
	@Id
	private Long idClient;
	@Column
	private String nomClient;
	@Column
	private double numClient;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST, mappedBy = "client", orphanRemoval = true)
	private List<Reservation> reservation = new ArrayList<Reservation>();

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public double getNumClient() {
		return numClient;
	}

	public void setNumClient(double numClient) {
		this.numClient = numClient;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", numClient=" + numClient + "]";
	}

	public Client(Long idClient, String nomClient, double numClient, List<Reservation> reservation) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.numClient = numClient;
		this.reservation = reservation;
	}

	public Client(Long idClient, String nomClient, double numClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.numClient = numClient;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

}
