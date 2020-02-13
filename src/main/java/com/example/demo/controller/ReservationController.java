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

import com.example.demo.entity.Menu;
import com.example.demo.entity.Reservation;
import com.example.demo.service.ClientService;
import com.example.demo.service.MenuService;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping(value = "/Reservation")
public class ReservationController {
	@Autowired
	private ReservationService revServ;
	@Autowired
	private ClientService cltServ;
	@Autowired
	private MenuService menServ;
String direction = "redirect:All";
	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutReservation(@ModelAttribute("reservation") Reservation reservation, ServletRequest req) {
		List<Menu> listmen = new ArrayList<Menu>();
		List<String> liststr = new ArrayList<String>();
		liststr = Arrays.asList(req.getParameterValues("menID"));

		for (String setri : liststr)
			listmen.add(menServ.GetByIdMenu(Long.parseLong(setri)));

		reservation.setMenu(listmen);
		revServ.AjoutReservationService(reservation);
		return direction;

	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppReservation(@ModelAttribute("reservation") Reservation reservation) {
		revServ.SupprimerReservationService(reservation);
		return direction;

	}
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateClient(@ModelAttribute("reservation") Reservation reservation) {

		revServ.UpdateReservationService(reservation);
		return new ModelAndView(direction);

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllReservation(@ModelAttribute("reservation") Reservation reservation, ModelMap model) {
		model.addAttribute("listeReservation", revServ.GetAllReservation());
		model.addAttribute("listeClient", cltServ.GetAllClient());
		model.addAttribute("listeMenu", menServ.GetAllMenu());
		return "reservation";

	}
	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdReservation(@ModelAttribute("reservation") Reservation reservation, ModelMap model) {
		model.addAttribute("laReservation", revServ.GetByIdReservation(reservation.getIdReservation()));
		return "lareservation";

	}
}
