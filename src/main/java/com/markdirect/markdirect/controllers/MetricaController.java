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
	
	@RequestMapping(value="productWomen",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> productWomen(){
		ArrayList<DatabaseData> productW=db.productWomen();
		return productW;
	}
	
	@RequestMapping(value="productMan",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> productMan(){
		ArrayList<DatabaseData> productM=db.productMan();
		System.out.println(productM);
		return productM;
	}
}
