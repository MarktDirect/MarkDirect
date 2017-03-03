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

	//Método que nos muestra toda la base de datos de los centros
	@RequestMapping(value="centros", method=RequestMethod.GET)
	public ModelAndView centros(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaCentros", db.listarCentros());
		mav.setViewName("centros");

		return mav;
	}

	//Método que da de alta a un nuevo centro
	@RequestMapping(value="altaCentro", method=RequestMethod.POST)
	public ModelAndView altaPromos(@RequestParam("centerName") String centerName,
			@RequestParam("centerAddres") String centerAddres,
			@RequestParam("centerDescription") String centerDescription,
			@RequestParam("centerType") String centerType,
			@RequestParam("centerSubtype") String centerSubtype) {

		System.out.println("Hola, yo soy la el centro " + centerName + "y mi descripción es: " + centerDescription);


		ModelAndView mav = new ModelAndView();
		if(db.addCentro(centerName, centerDescription, centerAddres, centerType, centerSubtype) == 1) {
			mav.setViewName("redirect:centros");
		} else {

		}
		return mav;
	}
}