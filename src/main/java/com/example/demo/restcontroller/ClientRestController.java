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

import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import com.example.demo.service.ReservationService;
@CrossOrigin
@RestController
@RequestMapping(value = "/ClientRest")
public class ClientRestController {
	@Autowired
	private ClientService cltService;
	@Autowired
	private ReservationService revServ;

	public ReservationService getRevServ() {
		return revServ;
	}

	public void setRevServ(ReservationService revServ) {
		this.revServ = revServ;
	}

	public ClientService getCltService() {
		return cltService;
	}

	public void setCltService(ClientService cltService) {
		this.cltService = cltService;
	}

//	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
//	public ResponseEntity<Object> AjoutCredit(@RequestBody Client crd) {
//		cltService.AjoutClientService(crd);
//		return new ResponseEntity<Object>("Client ajouté avec succès", HttpStatus.OK);
//	}
	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public void AjoutClient(@RequestBody Client crd) {
		cltService.AjoutClientService(crd);
	}
	

	@RequestMapping(value = "/Supprimer", method = RequestMethod.DELETE)
	public ResponseEntity<Object> SupprimerCredit(@RequestBody Client crd) {
		cltService.SupprimerClientService(crd);
		return new ResponseEntity<Object>("Client supprimé avec succès", HttpStatus.OK);
	}

	@RequestMapping(value = "/ChercherID/{idClient}", method = RequestMethod.GET)
	public Client ChercherClient(@PathVariable("idClient") String idClient) {
		System.out.println(cltService.GetByIdClient(Long.parseLong(idClient)));
		return cltService.GetByIdClient(Long.parseLong(idClient));
	}

	@RequestMapping(value = "/SupprimerID/{idClient}", method = RequestMethod.DELETE)
	public void SupprimerClient(@PathVariable("idClient") String idClient) {		
		cltService.SupprimerClientService(cltService.GetByIdClient(Long.parseLong(idClient)));
		//return new ResponseEntity<Object>("Client supprimé avec succès: ", HttpStatus.OK);
	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public List<Client> Chercher() {
		//return new ResponseEntity<Object>("Client cherché avec succès: " + cltService.GetAllClient(), HttpStatus.OK);
		return cltService.GetAllClient();
	}
}
