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
	public String altaPromos(@RequestParam("promoName") String promoName,
						@RequestParam("promoDescription") String promoDescription,
						@RequestParam("promoSince") String promoSince,
						@RequestParam("promoTo") String promoTo,
						@RequestParam("promoImg") String promoImg,
						@RequestParam("promo-zona") String zona,
						@RequestParam("promo-edad") String edad,
						@RequestParam("promo-sexo") String sexo) {
		
		//Necesitamos convertir el rango de edad que llega como un String a dos variables diferentes (edadMin - edadMax)
		
		return "promos";
	}
}
