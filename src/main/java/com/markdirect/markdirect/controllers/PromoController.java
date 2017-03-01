package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PromoController {

	@RequestMapping(value="promos", method=RequestMethod.POST)
	public String promos(@RequestParam("promo-titulo") String titulo,
						@RequestParam("promo-descripcion") String descripcion,
						@RequestParam("promo-validez") String validez,
						@RequestParam("promo-img") String img,
						@RequestParam("promo-zona") String zona,
						@RequestParam("promo-edad") String edad,
						@RequestParam("promo-sexo") String sexo) {
		return "promos";
	}
}
