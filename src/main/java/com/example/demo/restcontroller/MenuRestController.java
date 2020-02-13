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

import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;
@CrossOrigin
@RestController
@RequestMapping(value = "/MenuRest")
public class MenuRestController {
	@Autowired
	private MenuService plaService;

	public MenuService getCltService() {
		return plaService;
	}

	public void setCltService(MenuService plaService) {
		this.plaService = plaService;
	}

//	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
//	public ResponseEntity<Object> AjoutCredit(@RequestBody Menu crd) {
//		plaService.AjoutMenuService(crd);
//		return new ResponseEntity<Object>("Menu ajouté avec succès", HttpStatus.OK);
//	}
	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public void AjoutMenu(@RequestBody Menu crd) {
		plaService.AjoutMenuService(crd);
	}
	

	@RequestMapping(value = "/Supprimer", method = RequestMethod.DELETE)
	public ResponseEntity<Object> SupprimerMenu(@RequestBody Menu crd) {
		plaService.SupprimerMenuService(crd);
		return new ResponseEntity<Object>("Menu supprimé avec succès", HttpStatus.OK);
	}

	@RequestMapping(value = "/ChercherID/{idMenu}", method = RequestMethod.GET)
	public Menu ChercherMenu(@PathVariable("idMenu") String idMenu) {
		System.out.println(plaService.GetByIdMenu(Long.parseLong(idMenu)));
		return plaService.GetByIdMenu(Long.parseLong(idMenu));
	}

	@RequestMapping(value = "/SupprimerID/{idMenu}", method = RequestMethod.DELETE)
	public void SupprimerMenu(@PathVariable("idMenu") String idMenu) {		
		plaService.SupprimerMenuService(plaService.GetByIdMenu(Long.parseLong(idMenu)));
		//return new ResponseEntity<Object>("Menu supprimé avec succès: ", HttpStatus.OK);
	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public List<Menu> Chercher() {
		//return new ResponseEntity<Object>("Menu cherché avec succès: " + plaService.GetAllMenu(), HttpStatus.OK);
		return plaService.GetAllMenu();
	}
}
