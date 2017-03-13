package com.markdirect.markdirect.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.markdirect.markdirect.database.DatabaseMetricas;

/**
 * Controlador del home lleva a la pagina jsp del login
 */
@Controller
public class HomeController {
	
	@Autowired
	HttpSession session;
	
	DatabaseMetricas db = new DatabaseMetricas();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}

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
