package com.markdirect.markdirect.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//Controlador ocupado de dar validacion al usuario
@Controller

//Metodo que cargar la pagina login ,el mapping deberia ser "/" para poder iniciar en el login y luego entrar en el home
//De momento esta el "/login" a la espera que se pueda cambiar
public class LoginController {
	@RequestMapping( value="/login")
	public String Login(){
		return "Login";
	}

	//Metodo para comprobar si el usuario es valido o no
	@RequestMapping(value = "/validar", method = RequestMethod.GET)
	public ModelAndView Validar(
			@RequestParam("usuario") String usuario, 
			@RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();

		if(usuario.equals("admin") && password.equals("12345")){
			mav.setViewName("home");
		}else{
			mav.addObject("mensajeerror", "Usuario y/o email ya existen");
			mav.setViewName("Login");
		}


		return mav;
	}

}
