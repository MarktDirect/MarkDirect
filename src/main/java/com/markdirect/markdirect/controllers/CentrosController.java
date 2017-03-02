package com.markdirect.markdirect.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class CentrosController {
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/altaCentro")
	public String altaCentro(){
		return "altaCentro";
	}

}
