package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Client;
import com.example.demo.entity.Reservation;
import com.example.demo.service.ClientService;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping(value = "/Client")
public class ClientController {
	@Autowired
	private ClientService cltServ;
	@Autowired
	private ReservationService revServ;
	
	String direction = "redirect:All";

	public ClientService getCltServ() {
		return cltServ;
	}

	public void setCltServ(ClientService cltServ) {
		this.cltServ = cltServ;
	}

	public ReservationService getRevServ() {
		return revServ;
	}

	public void setRevServ(ReservationService revServ) {
		this.revServ = revServ;
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutTache(@ModelAttribute("client") Client client, ServletRequest req) {
		List<Reservation> listrev = new ArrayList<>();
		List<String> liststr = Arrays.asList(req.getParameterValues("revID"));

		for (String setri : liststr)
			listrev.add(revServ.GetByIdReservation(Long.parseLong(setri)));

		client.setReservation(listrev);
		cltServ.AjoutClientService(client);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateClient(@ModelAttribute("client") Client client) {

		cltServ.UpdateClientService(client);
		return new ModelAndView(direction);

	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppClient(@ModelAttribute("client") Client client) {
		cltServ.SupprimerClientService(client);
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllClient(@ModelAttribute("client") Client client, ModelMap model) {
		model.addAttribute("listeClient", cltServ.GetAllClient());
		model.addAttribute("listeReservation", revServ.GetAllReservation());
		return "client";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdClient(@ModelAttribute("client") Client client, ModelMap model) {
		model.addAttribute("leClient", cltServ.GetByIdClient(client.getIdClient()));
		return "leclient";

	}

//	@RequestMapping(value = "/ChercherNom", method = RequestMethod.GET)
//	public String findCitiesNameEndsWith(@ModelAttribute("client") Client client, ModelMap model) {
//
//		List<Client> clients = (List<Client>) cltServ.findByNameEndsWith(client.getNomClient());
//		model.addAttribute("clients", clients);
//		return "showCities";
//	}
}
