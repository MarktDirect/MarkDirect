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
import com.markdirect.markdirect.database.DatabaseMetricas;


//Controlador ocupado de dar validacion al usuario
@Controller
public class LoginController {
	
	//Se crea el objeto sesion
	@Autowired
	HttpSession session;
	
	//Creamos el objeto que nos va a servir para conectar con la BBDD
	DatabaseMetricas db = new DatabaseMetricas();
	
	//Aqui se crea el objeto usuario de la clase DataBaseMarkDirect que se ocupara de las consultas a la BD
	DatabaseMarkDirect administrador=new DatabaseMarkDirect();
	
	
	/**
	 * Metodo para comprobar si el usuario es valido o no
	 * @param usuario
	 * @param password
	 * @return devuelve un mav con la pagina que visitar y le a�ade un metodo para comprobar usuario
	 * ademas tambien devuelve atributos a�adidos a la sesion y crea la sesion del usuario
	 */
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView validar(
			@RequestParam("admin") String usuario, 
			@RequestParam("adminPassword") String password) {
		ModelAndView mav = new ModelAndView();
		try{//Se hace un try para comprobar si el usuario existe
		mav.addObject(administrador.login( usuario,password));//Se ejecuta un metodo que devolvera si existe
		mav.setViewName("home");
		}
		catch(EmptyResultDataAccessException e) {//Si el usuario no existe salta la excepcion y se le envia un mensaje
			mav.addObject("mensajeerror", "Usuario y/o password incorrectos");
			mav.setViewName ("login");
		}  
		//Atributos añadidos a la sesión para cargar datos de estadísticas
		session.setAttribute("usuario",administrador);
		session.setAttribute("totalUsers", db.totalUsers());
		session.setAttribute("averageAge", db.averageAge());
		session.setAttribute("totalSentPromos", db.totalSentPromos());
		session.setAttribute("totalGenericPromos", db.totalGenericSent());
		session.setAttribute("totalLocationPromos", db.totalLocationSent());

		return mav;
	}
	
	
	
	/**
	 * Metodo de deslogueo del usuario
	 * @param model
	 * @return un string indicando que debe volver a la pagina del login, cierra completamente la sesion
	 */
	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("mensajedespedida", "Sesión cerrada con exito");
		session.removeAttribute("usuario"); //eliminamos el user de la sesion
		session.invalidate(); //invalidar la session - se borra todo lo que hay dentro
		return "login";
	}

}

