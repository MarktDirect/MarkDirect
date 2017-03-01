package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PromoController {
	
	@RequestMapping(value="promos", method=RequestMethod.GET)
	public String promos() {
		return "promos";
	}
	
	
	@RequestMapping(value="altaPromos", method=RequestMethod.GET)
	public String altaPromos() {
		System.out.println("Hola, doy de alta una promo");
		return "promos";
	}
}
