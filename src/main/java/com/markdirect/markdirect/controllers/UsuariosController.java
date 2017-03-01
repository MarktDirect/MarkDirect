package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//Controlador de la pagina de usuarios
@Controller
public class UsuariosController {

	//Este metodo se ocupara de mostrar una tabla de todos los usuarios
	//En construccion
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView usuarios() {
		ModelAndView mav = new ModelAndView();

		return mav;
	}
}
