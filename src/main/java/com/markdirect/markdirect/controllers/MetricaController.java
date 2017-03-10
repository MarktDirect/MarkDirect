package com.markdirect.markdirect.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.markdirect.markdirect.beans.DatabaseData;
import com.markdirect.markdirect.database.DatabaseMetricas;

@Controller
public class MetricaController {

	//Creamos el objeto que nos va a servir para conectar con la BBDD
		DatabaseMetricas db = new DatabaseMetricas();
	
	@RequestMapping(value="usersByGender", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> usersByGender() {
		ArrayList<DatabaseData> users = db.usersByGender();
		return users;
	}
	
	@RequestMapping(value="usersByAgeAndGender", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> usersByAgeAndGender() {
		ArrayList<DatabaseData> users = db.usersByAgeAndGender();
		return users;
	}
	
	
	@RequestMapping(value="productWomen", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> productWomen() {
		ArrayList<DatabaseData> users = db.productWomen();
		return users;
	}
	
	@RequestMapping(value="productMan", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> productMan() {
		ArrayList<DatabaseData> users = db.productMan();
		return users;
	}
	
	
	@RequestMapping(value="marcaporgenerom", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> marcaPorGeneroM() {
		ArrayList<DatabaseData> marcaM = db.marcaGeneroM();
		return marcaM;
	}
	
	
	@RequestMapping(value="marcaporgeneroh", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> marcaPorGeneroH() {
		ArrayList<DatabaseData> marcaH = db.marcaGeneroH();
		return marcaH;
	}

	@RequestMapping(value="nivel1Women",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> nivel1Women(){
		ArrayList<DatabaseData> nivel1Women=db.nivel1Women();
		return nivel1Women;
	}
	
	@RequestMapping(value="nivel1Men",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> nivel1Men(){
		ArrayList<DatabaseData> nivel1Men=db.nivel1Men();
		System.out.println(nivel1Men);
		return nivel1Men;
	}

	
	@RequestMapping(value="sentPromosByGender",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> sentPromosByGender(){
		ArrayList<DatabaseData> promogenero = db.sentPromosByGender();

		return promogenero;
	}
	

}
