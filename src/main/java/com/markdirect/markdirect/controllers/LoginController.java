package com.markdirect.markdirect.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.beans.Administrador;
import com.markdirect.markdirect.database.Conector;
import com.markdirect.markdirect.database.DatabaseMarkDirect;


//Controlador ocupado de dar validacion al usuario
@Controller
public class LoginController {
	
	
	@Autowired
	HttpSession session;

	//Metodo para comprobar si el usuario es valido o no
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView Validar(
			@RequestParam("admin") String usuario, 
			@RequestParam("adminPassword") String password) {
		ModelAndView mav = new ModelAndView();
		DatabaseMarkDirect administrador=new DatabaseMarkDirect();
		
		
		try{
		mav.addObject(administrador.login( usuario,password));
		mav.setViewName("home");
		}
		catch(EmptyResultDataAccessException e) {
			mav.addObject("mensajeerror", "Usuario y/o Usuario y/o contrase�a no son correctos");
			mav.setViewName ("login");
		}  
		
		session.setAttribute("usuario",administrador);

		return mav;
	}

}

