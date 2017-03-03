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

	//método para añadir zonas
	/**
	 * This method calls to insertarZonaControl inserting the @RequestParam of the form as parameters
	 * @param controlzoneMajor
	 * @param controlzoneMinor
	 * @param controlzoneEmplacement
	 * @param controlzone_centerId
	 * @return the new ModelAndView
	 */
	@RequestMapping(value="altaZonas", method = RequestMethod.POST)
	public ModelAndView addZonas(
			@RequestParam("controlzoneMajor") String controlzoneMajor,
			@RequestParam("controlzoneMinor") String controlzoneMinor,
			@RequestParam("controlzoneEmplacement") String controlzoneEmplacement,
			@RequestParam("controlzone_centerId") int controlzone_centerId
			){
		
		//insertar zona de control en BBDD
		int algodon = db.insertarZonaControl(controlzoneMajor, controlzoneMinor, controlzoneEmplacement, controlzone_centerId);
		System.out.println(algodon);
		
		//Vista
		ModelAndView mav = new ModelAndView();
		if(algodon == 1){
			mav.addObject("mensaje", "Zona de control cargada con éxito");
			mav.setViewName("redirect:zonas");
		}
		
		return mav;
		
	}
	
}
