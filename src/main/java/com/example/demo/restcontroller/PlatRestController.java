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

import com.example.demo.entity.Plat;
import com.example.demo.service.PlatService;
@CrossOrigin
@RestController
@RequestMapping(value = "/PlatRest")
public class PlatRestController {
	@Autowired
	private PlatService plaService;

	public PlatService getCltService() {
		return plaService;
	}

	public void setCltService(PlatService plaService) {
		this.plaService = plaService;
	}

//	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
//	public ResponseEntity<Object> AjoutCredit(@RequestBody Plat crd) {
//		plaService.AjoutPlatService(crd);
//		return new ResponseEntity<Object>("Plat ajouté avec succès", HttpStatus.OK);
//	}
	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public void AjoutCredit(@RequestBody Plat crd) {
		plaService.AjoutPlatService(crd);
	}
	

	@RequestMapping(value = "/Supprimer", method = RequestMethod.DELETE)
	public ResponseEntity<Object> SupprimerCredit(@RequestBody Plat crd) {
		plaService.SupprimerPlatService(crd);
		return new ResponseEntity<Object>("Plat supprimé avec succès", HttpStatus.OK);
	}

	@RequestMapping(value = "/ChercherID/{idPlat}", method = RequestMethod.GET)
	public Plat ChercherPlat(@PathVariable("idPlat") String idPlat) {
		System.out.println(plaService.GetByIdPlat(Long.parseLong(idPlat)));
		return plaService.GetByIdPlat(Long.parseLong(idPlat));
	}

	@RequestMapping(value = "/SupprimerID/{idPlat}", method = RequestMethod.DELETE)
	public void SupprimerPlat(@PathVariable("idPlat") String idPlat) {		
		plaService.SupprimerPlatService(plaService.GetByIdPlat(Long.parseLong(idPlat)));
		//return new ResponseEntity<Object>("Plat supprimé avec succès: ", HttpStatus.OK);
	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public List<Plat> Chercher() {
		//return new ResponseEntity<Object>("Plat cherché avec succès: " + plaService.GetAllPlat(), HttpStatus.OK);
		return plaService.GetAllPlat();
	}
}
