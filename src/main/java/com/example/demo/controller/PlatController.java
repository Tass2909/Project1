package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Plat;
import com.example.demo.service.MenuService;
import com.example.demo.service.PlatService;

@Controller
@RequestMapping(value = "/Plat")
public class PlatController {
	@Autowired
	private PlatService plaServ;

	@Autowired
	private MenuService menServ;

	String direction = "redirect:All";
	public PlatService getPlaServ() {
		return plaServ;
	}

	public void setPlaServ(PlatService plaServ) {
		this.plaServ = plaServ;
	}

	public MenuService getMenServ() {
		return menServ;
	}

	public void setMenServ(MenuService menServ) {
		this.menServ = menServ;
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutPlat(@ModelAttribute("plat") Plat plat) {

		plaServ.AjoutPlatService(plat);
		return direction;

	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppPlat(@ModelAttribute("plat") Plat plat) {
		plaServ.SupprimerPlatService(plat);
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllPlat(@ModelAttribute("plat") Plat phase, ModelMap model) {
		model.addAttribute("listePlat", plaServ.GetAllPlat());
		model.addAttribute("listeMenu", menServ.GetAllMenu());
		return "plat";

	}
	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdPlat(@ModelAttribute("plat") Plat plat, ModelMap model) {
		model.addAttribute("lePlat", plaServ.GetByIdPlat(plat.getIdPlat()));
		return "leplat";

	}
}
