package com.markdirect.markdirect.controllers;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.database.DatabaseMarkDirect;


//Controlador de la pagina de usuarios
@Controller
public class UsuariosController {

	
	//Metodo que muestra en el jsp una lista de los usuarios
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView usuarios() {
		ModelAndView mav = new ModelAndView();
		DatabaseMarkDirect usuario = new DatabaseMarkDirect();
		mav.setViewName("usuarios");
		mav.addObject("usuario",usuario.listarUsuarios());

		
		

		return mav;
	}
}
