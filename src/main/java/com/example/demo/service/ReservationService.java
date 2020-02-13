package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservationDAO;
import com.example.demo.entity.Reservation;

@Service
public class ReservationService {
	@Autowired
	private IReservationDAO cltdao;

	public IReservationDAO getCltdao() {
		return cltdao;
	}

	public void setCltdao(IReservationDAO cltdao) {
		this.cltdao = cltdao;
	}

	public void AjoutReservationService(Reservation clt) {
		cltdao.save(clt);
	}

	public void SupprimerReservationService(Reservation clt) {
		cltdao.delete(clt);
	}

	public Reservation GetByIdReservation(Long idReservation) {
		return cltdao.getOne(idReservation);
	}

	public void UpdateReservationService(Reservation clt) {
		cltdao.saveAndFlush(clt);
	}

	public List<Reservation> GetAllReservation() {
		return cltdao.findAll();
	}

}
