package com.markdirect.markdirect.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.markdirect.markdirect.database.DatabaseMetricas;


@Controller
public class HomeController {
	
	@Autowired
	HttpSession session;
	
	DatabaseMetricas db = new DatabaseMetricas();
	
	/**
	 * M�todo que nos lleva a la vista del login
	 * @return login : nos manda a la vista de login
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}

	/**
	 * M�todo que conecta con la base de datos y guarda en la sesi�n el n�mero total de usuarios,
	 * la edad media, el n�mero de promociones enviadas, el numero de promociones por genero
	 * y las promociones enviadas por localizaci�n
	 * @return home, nos manda a la home page
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String backHome() {
		session.setAttribute("totalUsers", db.totalUsers());
		session.setAttribute("averageAge", db.averageAge());
		session.setAttribute("totalSentPromos", db.totalSentPromos());
		session.setAttribute("totalGenericPromos", db.totalGenericSent());
		session.setAttribute("totalLocationPromos", db.totalLocationSent());
		return "home";
	}

}
