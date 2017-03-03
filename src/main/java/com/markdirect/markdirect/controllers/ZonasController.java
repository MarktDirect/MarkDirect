package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.database.DatabaseMarkDirect;

@Controller
public class ZonasController {
	
	DatabaseMarkDirect db = new DatabaseMarkDirect();
	
	@RequestMapping(value="/zonas", method = RequestMethod.GET)
	public ModelAndView zonas(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaZonas", db.listarZonas());
		mav.setViewName("zonas");
		return mav;
	}

	//TODO método para añadir zonas
	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView añadirZonas(
			@RequestParam("controlzoneMajor") String controlzoneMajor,
			@RequestParam("controlzoneMajor") String controlzoneMinor,
			@RequestParam("controlzoneMajor") String controlzoneEmplacement,
			@RequestParam("controlzoneMajor") int controlzone_centerId
			){
		
		//insertar zona de control en BBDD
		db.insertarZonaControl(controlzoneMajor, controlzoneMinor, controlzoneEmplacement, controlzone_centerId);
		
		//añadir vista
		ModelAndView mav = this.zonas();
		
		return mav;
		
	}
	
}
