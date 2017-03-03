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

	@RequestMapping(value="altaCentro", method=RequestMethod.POST)
	public String altaPromos(@RequestParam("centerNombre") String nombre,
			@RequestParam("centerDireccion") String direccion,
			@RequestParam("centerDescription") String descripcion,
			@RequestParam("centerTipo") String tipo,
			@RequestParam("centerSubtipo") String subtipo) {

		System.out.println("Hola, yo soy la el centro " + nombre + "y mi descripción es: " + descripcion);


		String sql="INSERT INTO centers WHERE ('centerName','centerDireccion','centerDescription'"
				+ " 'centerType', 'centerSubtype') VALUES ('nombre','direccion','descripcion','tipo','subtipo'";

		return "centros";
	}
}