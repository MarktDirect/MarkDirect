package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador del home lleva a la pagina jsp del login
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String backHome() {
		return "home";
	}

}
