package com.markdirect.markdirect.controllers;

import java.util.List;


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
		mav.setViewName("usuarios");
		
		//Metodo para sacar la tabla en usuarios comentado
		/*
		 * JdbcTemplate db= new JdbcTemplate(Conector.getDataSource());
		 * String SQL="SELECT*FROM Usuarios";
		List<Usuario> listausuario = db.query(
				SQL, new BeanPropertyRowMapper<Usuario>(Usuario.class));
				mav.addObject("lista",listausuario);
		 */
		

		
		

		return mav;
	}
}
