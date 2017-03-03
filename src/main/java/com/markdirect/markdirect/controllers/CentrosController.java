package com.markdirect.markdirect.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CentrosController {


	@RequestMapping(value="centros", method=RequestMethod.GET)
	public String centros(){

		//Hacemos consulta a base de datos para que nos cargue todos los centros que hay
		String sql="SELECT * FROM centers";

		return "centros";
	}

	@RequestMapping(value="altaCentro", method=RequestMethod.POST)
	public String altaPromos(@RequestParam("centerNombre") String nombre,
			@RequestParam("centerDireccion") String direccion,
			@RequestParam("centerDescription") String descripcion,
			@RequestParam("centerTipo") String tipo,
			@RequestParam("centerSubtipo") String subtipo) {

		System.out.println("Hola, yo soy la el centro " + nombre + "y mi descripción es: " + descripcion);


		String sql="INSERT INTO centers WHERE ('centerNombre','centerDireccion','centerDescription'"
				+ " 'centerTipo', 'centerSubtipo') VALUES ('nombre','direccion','descripcion','tipo','subtipo'";

		return "centros";
	}
}