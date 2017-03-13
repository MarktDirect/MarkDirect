package com.markdirect.markdirect.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.database.DatabaseMarkDirect;

@Controller
public class CentrosController {

	DatabaseMarkDirect db = new DatabaseMarkDirect();

	/**
	 * 	M�todo que nos muestra toda la base de datos de los centros
	 * @return mav.setViewName("centros"): vista con la lista de todos los centros
	 */
	@RequestMapping(value="centros", method=RequestMethod.GET)
	public ModelAndView centros(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaCentros", db.listarCentros());
		mav.setViewName("centros");

		return mav;
	}

	/**
	 * 	M�todo que nos muestra toda la base de datos de los centros
	 * @return mav.setViewName("centros"): vista con la lista de todos los centros
	 */
	@RequestMapping(value="centroszonas", method=RequestMethod.GET)
	public ModelAndView centroszonas(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaCentros", db.listarCentros());
		mav.addObject("listaZonas", db.listarZonas());
		mav.setViewName("centroszonas");

		return mav;
	}



	/**
	 * M�todo que da de alta a un nuevo centro
	 * @param centerName 
	 * @param centerAddres
	 * @param centerDescription
	 * @param centerType
	 * @param centerSubtype
	 * @return mav.setViewName("redirect:centros"): nos devuelve la vista de todos los centros
	 * actualizado con la nueva alta
	 */
	@RequestMapping(value="centros", method=RequestMethod.POST)
	public ModelAndView altaPromos(@RequestParam("centerName") String centerName,
			@RequestParam("centerAddres") String centerAddres,
			@RequestParam("centerDescription") String centerDescription,
			@RequestParam("centerType") String centerType,
			@RequestParam("centerSubtype") String centerSubtype) {

		ModelAndView mav = new ModelAndView();
		if(db.addCentro(centerName, centerDescription, centerAddres, centerType, centerSubtype) == 1) {

			mav.addObject("mensaje", "Centro a�adido con exito");
			mav.addObject("listaCentros", db.listarCentros());
			mav.setViewName("centros");

		} else {
			mav.addObject("mensaje","Centro no a�adido con exito");
			mav.addObject("listaCentros", db.listarCentros());
			mav.setViewName("centros");

		}

		return mav;
	}

}