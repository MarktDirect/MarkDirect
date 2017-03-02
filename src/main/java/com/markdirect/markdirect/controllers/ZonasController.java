package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
