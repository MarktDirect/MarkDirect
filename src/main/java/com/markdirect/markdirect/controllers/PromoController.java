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
	 * MÃ©todo que nos lista las promociones disponibles
	 */
	@RequestMapping(value="promos", method=RequestMethod.GET)
	public ModelAndView promos() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaPromos", db.listarPromociones());
		mav.addObject("listaCat1", db.listarCategoriasNivel1());
		mav.setViewName("promos");
		return mav;
	}

	/*
	 * MÃ©todo que da de alta una promociÃ³n en la base de datos
	 */
	@RequestMapping(value="promos", method=RequestMethod.POST)
	public ModelAndView altaPromos(@RequestParam("promoName") String promoName,
			@RequestParam("promoDescription") String promoDescription,
			@RequestParam("promoSince") String promoSince,
			@RequestParam("promoTo") String promoTo,
			@RequestParam("promoImage") String promoImage,
			@RequestParam("promo_controlzoneId") int promo_controlzoneId,
			@RequestParam("promoMinAge") int promoMinAge,
			@RequestParam("promoMaxAge") int promoMaxAge,
			@RequestParam("promoGen") String promoGen,
			@RequestParam("promo_catNivel1") int promo_catNivel1,
			@RequestParam("promo_catNivel2") int promo_catNivel2,
			@RequestParam("promo_idProduct") long promo_idProduct
			) {

		ModelAndView mav = new ModelAndView();
		if(db.addPromo(promoName, promoDescription, promoSince, promoTo, promoImage, promo_controlzoneId, promoMinAge, promoMaxAge, promoGen, promo_catNivel1, promo_catNivel2, promo_idProduct) == 1) {
			//TODO aÃ±adir mensaje al mav para avisar al usuario que se ha registrado con Ã©xito
			mav.addObject("mensaje", "Promocion aÃ±adido con exito");
			mav.addObject("listaPromos", db.listarPromociones());
			mav.setViewName("promos");

		} else {
			mav.addObject("mensaje", "Promocion no aÃ±adido con exito");
			mav.addObject("listaPromos", db.listarPromociones());
			mav.setViewName("promos");

		}

		return mav;
	}

	/**
	 * Método para editar las promociones
	 * Todos los parámetros que se le introducen son los atributos que tiene la clase promoción
	 * @param promoId
	 * @param promoName
	 * @param promoDescription
	 * @param promoSince
	 * @param promoTo
	 * @param promoImage
	 * @param promo_controlzoneId
	 * @param promoMinAge
	 * @param promoMaxAge
	 * @param promoGen
	 * @param promo_catNivel1
	 * @param promo_catNivel2
	 * @param promo_idProduct
	 * @return mav: nos manda a la vista de promocioens, introducimos los campos a modificar de la 
	 * promoción, nos manda un mensaje si la modificación ha sido realizada con éxito o no
	 */
	@RequestMapping(value="editPromos", method=RequestMethod.GET)
	public ModelAndView editPromos(@RequestParam("promoId") int promoId, 
			@RequestParam("promoName") String promoName,
			@RequestParam("promoDescription") String promoDescription,
			@RequestParam("promoSince") String promoSince,
			@RequestParam("promoTo") String promoTo,
			@RequestParam("promoImage") String promoImage,
			@RequestParam("promo_controlzoneId") int promo_controlzoneId,
			@RequestParam("promoMinAge") int promoMinAge,
			@RequestParam("promoMaxAge") int promoMaxAge,
			@RequestParam("promoGen") String promoGen,
			@RequestParam("promo_catNivel1") int promo_catNivel1,
			@RequestParam("promo_catNivel2") int promo_catNivel2,
			@RequestParam("promo_idProduct") long promo_idProduct) {

		ModelAndView mav = new ModelAndView();
		if(db.editPromos(promoId, promoName, promoDescription, promoSince, promoTo, promoImage, promo_controlzoneId, promoMinAge, promoMaxAge, promoGen, promo_catNivel1, promo_catNivel2, promo_idProduct) == 1) {
			mav.addObject("mensaje", "Promocion modificada con exito");
			mav.addObject("listaPromos", db.listarPromociones());
			mav.setViewName("promos");
		} else {
			mav.addObject("mensaje", "Error al modificar la promociÃ³n");
			mav.addObject("listaPromos", db.listarPromociones());
			mav.setViewName("promos");
		}

		return mav;
	}
	
	@RequestMapping(value="deletePromo", method=RequestMethod.POST)
	public ModelAndView detelePromo(@RequestParam("promoId") int promoId){
		ModelAndView mav = new ModelAndView();
		System.out.println(promoId);
		if(db.deletePromo(promoId) == 1){
			mav.addObject("mensaje", "Promoción eliminada con éxito");
			mav.addObject("listaPromos", db.listarPromociones());
			mav.addObject("listaCat1", db.listarCategoriasNivel1());
			mav.setViewName("promos");
		} else {
			mav.addObject("mensaje", "Error al eliminar promoción");
			mav.addObject("listaPromos", db.listarPromociones());
			mav.addObject("listaCat1", db.listarCategoriasNivel1());
			mav.setViewName("promos");
		}
		
		return mav;
		
	}
	
}
