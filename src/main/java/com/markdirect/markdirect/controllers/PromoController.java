package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.markdirect.markdirect.database.DatabaseMarkDirect;

@Controller
public class PromoController {
	
	DatabaseMarkDirect db = new DatabaseMarkDirect();
	
	@RequestMapping(value="promos", method=RequestMethod.GET)
	public String promos() {
		return "promos";
	}
	
	
	@RequestMapping(value="altaPromos", method=RequestMethod.POST)
	public String altaPromos(@RequestParam("promo-titulo") String titulo,
						@RequestParam("promo-descripcion") String descripcion,
						@RequestParam("promo-validezDesde") String validezDesde,
						@RequestParam("promo-validezHasta") String validezHasta,
						@RequestParam("promo-img") String img,
						@RequestParam("promo-zona") String zona,
						@RequestParam("promo-edad") String edad,
						@RequestParam("promo-sexo") String sexo) {
		
		System.out.println("Hola, yo soy la promo " + titulo + " y mi descripción es: " + descripcion);
		
		return "promos";
	}
}
