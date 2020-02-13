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
import com.example.demo.entity.Plat;
import com.example.demo.service.MenuService;
import com.example.demo.service.PlatService;

@Controller
@RequestMapping(value = "/Menu")
public class MenuController {
	@Autowired
	private MenuService menServ;
	@Autowired
	private PlatService plaServ;

	String direction = "redirect:All";
	public MenuService getMenServ() {
		return menServ;
	}

	public void setMenServ(MenuService menServ) {
		this.menServ = menServ;
	}

	public PlatService getPlaServ() {
		return plaServ;
	}

	public void setPlaServ(PlatService plaServ) {
		this.plaServ = plaServ;
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutTache(@ModelAttribute("menu") Menu menu, ServletRequest req) {
		List<Plat> listpla = new ArrayList<Plat>();
		List<String> liststr = new ArrayList<String>();
		liststr = Arrays.asList(req.getParameterValues("plaID"));

		for (String setri : liststr)
			listpla.add(plaServ.GetByIdPlat(Long.parseLong(setri)));

		menu.setPlat(listpla);
		menServ.AjoutMenuService(menu);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateMenu(@ModelAttribute("menu") Menu menu) {

		menServ.UpdateMenuService(menu);
		return new ModelAndView(direction);

	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppMenu(@ModelAttribute("menu") Menu menu) {
		menServ.SupprimerMenuService(menu);
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllMenu(@ModelAttribute("menu") Menu menu, ModelMap model) {
		model.addAttribute("listeMenu", menServ.GetAllMenu());
		model.addAttribute("listePlat", plaServ.GetAllPlat());
		return "menu";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdMenu(@ModelAttribute("menu") Menu menu, ModelMap model) {
		model.addAttribute("leMenu", menServ.GetByIdMenu(menu.getIdMenu()));
		return "lemenu";

	}
}
