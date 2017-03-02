package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.database.DatabaseMarkDirect;

@Controller
public class PromoController {
	
	DatabaseMarkDirect db = new DatabaseMarkDirect();
	
	@RequestMapping(value="promos", method=RequestMethod.GET)
	public ModelAndView promos() {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println(db.listarPromociones());
		mav.addObject("listaPromos", db.listarPromociones());
		mav.setViewName("promos");
		return mav;
	}
	
	
	@RequestMapping(value="altaPromos", method=RequestMethod.POST)
	public String altaPromos(@RequestParam("promoName") String promoName,
						@RequestParam("promoDescription") String promoDescription,
						@RequestParam("promoSince") String promoSince,
						@RequestParam("promoTo") String promoTo,
						@RequestParam("promoImage") String promoImage,
						@RequestParam("promo_controlZoneId") int promo_controlZoneId,
						@RequestParam("promoMinAge") int promoMinAge,
						@RequestParam("promoMaxAge") int promoMaxAge,
						@RequestParam("promoGen") String promoGen) {
		
		/*
		 * Tenemos que guardar de alguna forma el día y la hora en la que se ha creado la promo
		 */
		
		return "promos";
	}
}
