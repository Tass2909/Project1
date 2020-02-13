package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()

public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/initPlat", method = RequestMethod.GET)
	public String initPlat() {

		return "redirect:/Plat/All";
	}

	@RequestMapping(value = "/initMenu", method = RequestMethod.GET)
	public String initMenu() {

		return "redirect:/Menu/All";
	}

	@RequestMapping(value = "/initClient", method = RequestMethod.GET)
	public String initClient() {

		return "redirect:/Client/All";
	}

	@RequestMapping(value = "/initReservation", method = RequestMethod.GET)
	public String initReservation() {

		return "redirect:/Reservation/All";
	}
	
	@RequestMapping(value = "/initRole", method = RequestMethod.GET)
	public String initRole() {

		return "redirect:/Role/All";
	}
	
	@RequestMapping(value = "/initUser", method = RequestMethod.GET)
	public String initUser() {

		return "redirect:/User/All";
	}

}
