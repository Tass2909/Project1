package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;
@CrossOrigin
@RestController
@RequestMapping(value = "/ReservationRest")
public class ReservationRestController {
	@Autowired
	private ReservationService revService;

	public ReservationService getCltService() {
		return revService;
	}

	public void setCltService(ReservationService revService) {
		this.revService = revService;
	}

//	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
//	public ResponseEntity<Object> AjoutCredit(@RequestBody Reservation crd) {
//		revService.AjoutReservationService(crd);
//		return new ResponseEntity<Object>("Reservation ajouté avec succès", HttpStatus.OK);
//	}
	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public void AjoutCredit(@RequestBody Reservation crd) {
		revService.AjoutReservationService(crd);
	}
	

	@RequestMapping(value = "/Supprimer", method = RequestMethod.DELETE)
	public ResponseEntity<Object> SupprimerCredit(@RequestBody Reservation crd) {
		revService.SupprimerReservationService(crd);
		return new ResponseEntity<Object>("Reservation supprimé avec succès", HttpStatus.OK);
	}

	@RequestMapping(value = "/ChercherID/{idReservation}", method = RequestMethod.GET)
	public Reservation ChercherReservation(@PathVariable("idReservation") String idReservation) {
		System.out.println(revService.GetByIdReservation(Long.parseLong(idReservation)));
		return revService.GetByIdReservation(Long.parseLong(idReservation));
	}

	@RequestMapping(value = "/SupprimerID/{idReservation}", method = RequestMethod.DELETE)
	public void SupprimerReservation(@PathVariable("idReservation") String idReservation) {		
		revService.SupprimerReservationService(revService.GetByIdReservation(Long.parseLong(idReservation)));
		//return new ResponseEntity<Object>("Reservation supprimé avec succès: ", HttpStatus.OK);
	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public List<Reservation> Chercher() {
		//return new ResponseEntity<Object>("Reservation cherché avec succès: " + revService.GetAllReservation(), HttpStatus.OK);
		return revService.GetAllReservation();
	}
}
