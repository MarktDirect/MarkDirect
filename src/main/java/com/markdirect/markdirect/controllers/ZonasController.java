package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ZonasController {
	
	
	@RequestMapping(value="/zonas", method = RequestMethod.GET)
	public String zonas(){
		return "zonas";
	}

}
