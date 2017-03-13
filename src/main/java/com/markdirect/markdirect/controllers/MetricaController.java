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
		 * M�todo que guarda en un ArrayList la consulta a la base de datos
		 * @return users: ArrayList<DatabaseData> con los usuarios seg�n g�nero
		 */
	@RequestMapping(value="usersByGender", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> usersByGender() {
		ArrayList<DatabaseData> users = db.usersByGender();
		return users;
	}
	
	/**
	 * M�todo que guarda en un ArrayList la consulta a la base de datos
	 * @return user: ArrayList<DatabaseData> con los usuarios seg�n g�nero y edad
	 */
	@RequestMapping(value="usersByAgeAndGender", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> usersByAgeAndGender() {
		ArrayList<DatabaseData> users = db.usersByAgeAndGender();
		return users;
	}
	
	/**
	 *  M�todo que guarda en un ArrayList la consulta a la base de datos
	 * @return user: ArrayList<DatabaseData> con los productos m�s enviados a mujeres
	 */
	@RequestMapping(value="productWomen", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> productWomen() {
		ArrayList<DatabaseData> users = db.productWomen();
		return users;
	}
	
	/**
	 *  M�todo que guarda en un ArrayList la consulta a la base de datos
	 * @return user: ArrayList<DatabaseData> con los productos m�s enviados a hombres
	 */
	@RequestMapping(value="productMan", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> productMan() {
		ArrayList<DatabaseData> users = db.productMan();
		return users;
	}
	
	/**
	 *  M�todo que guarda en un ArrayList la consulta a la base de datos
	 * @return marcaM: ArrayList<DatabaseData> con la marca m�s enviados a mujeres
	 */
	@RequestMapping(value="brandWomen", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> brandWomen() {
		ArrayList<DatabaseData> marcaM = db.brandWomen();
		return marcaM;
	}
	
	/**
	 *  M�todo que guarda en un ArrayList la consulta a la base de datos
	 * @return marcaH: ArrayList<DatabaseData> con la marca m�s enviados a hombres
	 */
	@RequestMapping(value="brandMen", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> brandMen() {
		ArrayList<DatabaseData> marcaH = db.brandMen();
		return marcaH;
	}

	/**
	 *  M�todo que guarda en un ArrayList la consulta a la base de datos
	 * @return nivel1Women: ArrayList<DatabaseData> con los niveles de tipo 1 m�s enviados a mujeres
	 */
	@RequestMapping(value="nivel1Women",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> nivel1Women(){
		ArrayList<DatabaseData> nivel1Women=db.nivel1Women();
		return nivel1Women;
	}
	/**
	 *  M�todo que guarda en un ArrayList la consulta a la base de datos
	 * @return nivel1Men: ArrayList<DatabaseData> con los niveles de tipo 1 m�s enviados a hombress
	 */
	@RequestMapping(value="nivel1Men",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> nivel1Men(){
		ArrayList<DatabaseData> nivel1Men=db.nivel1Men();
		return nivel1Men;
	}

	/**
	 *  M�todo que guarda en un ArrayList la consulta a la base de datos
	 * @return level1ByAge: ArrayList<DatabaseData> con las promocioness por nievel
	 *  m�s enviadas seg�n la edad
	 */
	@RequestMapping(value="level1ByAge", method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> level1ByAge() {
		ArrayList<DatabaseData> level1ByAge = db.level1ByAge();
		return level1ByAge;
	}
	/**
	 *  M�todo que guarda en un ArrayList la consulta a la base de datos
	 * @return promogenero: ArrayList<DatabaseData> con las promocioness m�s enviadas por g�nero
	 */
	@RequestMapping(value="sentPromosByGender",  method=RequestMethod.GET)
	public @ResponseBody ArrayList<DatabaseData> sentPromosByGender(){
		ArrayList<DatabaseData> promogenero = db.sentPromosByGender();
		return promogenero;
	}
	
}
