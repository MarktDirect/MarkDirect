package com.markdirect.markdirect.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CentrosController {
	
	
	@RequestMapping(value="centros", method=RequestMethod.GET)
	public String centros(){
		return "centros";
	}
	
	@RequestMapping(value="altaCentro", method=RequestMethod.POST)
	public String altaPromos(@RequestParam("centro-nombre") String nombre,
						@RequestParam("centro-direccion") String direccion,
						@RequestParam("centro-descripcion") String descripcion,
						@RequestParam("centro-tipo") String tipo,
						@RequestParam("centro-subtipo") String subtipo) {
		
		System.out.println("Hola, yo soy la el centro " + nombre + "y mi descripción es: " + descripcion);
		
		return "centros";
	}
	

}
