package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.database.DatabaseMarkDirect;

@Controller
public class PromoController {
	
	//Creamos el objeto que nos va a servir para conectar con la BBDD
	DatabaseMarkDirect db = new DatabaseMarkDirect();
	
	/*
	 * Método que nos lista las promociones disponibles
	 */
	@RequestMapping(value="/promos", method=RequestMethod.GET)
	public ModelAndView promos() {
		System.out.println("Entro a promos");
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaPromos", db.listarPromociones());
		mav.setViewName("promos");
		return mav;
	}
	
	/*
	 * Método que da de alta una promoción en la base de datos
	 */
	@RequestMapping(value="altaPromos", method=RequestMethod.POST)
	public ModelAndView altaPromos(@RequestParam("promoName") String promoName,
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
		ModelAndView mav = new ModelAndView();
		if(db.addPromo(promoName, promoDescription, promoSince, promoTo, promoImage, promo_controlZoneId, promoMinAge, promoMaxAge, promoGen) == 1) {
			mav.addObject("mensaje", "promoción añadida con éxito");mav.setViewName("promos");
		} else {
			System.out.println("ERROR MÁXIMO");
		}
		
		return mav;
	}
}
