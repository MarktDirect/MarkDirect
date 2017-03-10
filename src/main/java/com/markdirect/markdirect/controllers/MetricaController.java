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
	
	
	/**
	 * Metodo que saca un arraylist de los usuarios que hay en la DB dependiendo del genero
	 * @return devuelve un arraylist con todos los usuarios que hay dividos por genero
	 */
	@RequestMapping(value="usersByGender", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> usersByGender() {
		ArrayList<DatabaseData> users = db.usersByGender();
		return users;
	}
	

	/**
	 * Metodo para sacar un arraylist de los usuarios por genero y edad
	 * @return devuelve un arraylist json de los usuarios dividios por genero y edad
	 */
	@RequestMapping(value="usersByAgeAndGender", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> usersByAgeAndGender() {
		ArrayList<DatabaseData> users = db.usersByAgeAndGender();
		return users;
	}
	
	
	
	/**
	 * Metodo para sacar los productos dirigidos a mujeres
	 * @return devuelve un arraylist json de los productos que van dirigidos a mujeres
	 */
	@RequestMapping(value="productWomen", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> productWomen() {
		ArrayList<DatabaseData> users = db.productWomen();
		return users;
	}
	
	
	/**
	 * Metodo para sacar los productos dirigidos a hombres
	 * @return devuelve un arraylist json de los productos dirigidos a hombres
	 */
	@RequestMapping(value="productMan", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> productMan() {
		ArrayList<DatabaseData> users = db.productMan();
		return users;
	}
	
	
	
	/**
	 * Metodo para sacar las marcas dirigidas a mujeres
	 * @return devuelve un arraylist json de las marcas dirigidas a mujeres
	 */
	@RequestMapping(value="brandWomen", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> brandWomen() {
		ArrayList<DatabaseData> marcaM = db.brandWomen();
		return marcaM;
	}
	
	

	/**
	 * Metodo para sacar las marcas dirigidas a hombres
	 * @return devuelve un arraylist json de las marcas dirigidas a hombres
	 */
	@RequestMapping(value="brandMen", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> brandMen() {
		ArrayList<DatabaseData> marcaH = db.brandMen();
		return marcaH;
	}

	
	/**
	 * Metodo para sacar los productos de categoria 1 dirigidas a mujeres
	 * @return devuelve un arraylist json de los productos de categoria 1 dirigidas a mujeres
	 */
	@RequestMapping(value="nivel1Women",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> nivel1Women(){
		ArrayList<DatabaseData> nivel1Women=db.nivel1Women();
		return nivel1Women;
	}
	

	/**
	 * Metodo para sacar los productos de categoria 1 dirigidas a hombres
	 * @return devuelve un arraylist json de los productos de categoria 1 dirigidas a hombres
	 */
	@RequestMapping(value="nivel1Men",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> nivel1Men(){
		ArrayList<DatabaseData> nivel1Men=db.nivel1Men();
		return nivel1Men;
	}

	
	
	/**
	 * Metodo para sacar los productos enviados por genero
	 * @return devuelve un arraylist json de los productos enviados por genero
	 */
	@RequestMapping(value="sentPromosByGender",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> sentPromosByGender(){
		ArrayList<DatabaseData> promogenero = db.sentPromosByGender();
		return promogenero;
	}

}
