package com.markdirect.markdirect.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.markdirect.markdirect.beans.ListaPromosJSON;
import com.markdirect.markdirect.beans.PromoJSON;
import com.markdirect.markdirect.beans.Promocion;
import com.markdirect.markdirect.beans.Usuario;
import com.markdirect.markdirect.database.DatabaseMarkDirect;

@Controller
public class JsonController {

	//Creamos el objeto que nos va a servir para conectar con la BBDD
	DatabaseMarkDirect db = new DatabaseMarkDirect();
	
	/**
	 * Método que realiza una consulta a la BBDD, lista todas las promociones y devuelve la lista en formato JSON
	 * @return List<Promocion> - lista de todas las promociones
	 */
	@RequestMapping(value="getAllPromos", method=RequestMethod.GET)
	public @ResponseBody List<Promocion> getAllPromos() {
		//Obtenemos la lista entera de promociones del método que tenemos en DatabaseMarkDirect
		List<Promocion> promociones = db.listarPromociones();
		return promociones;
	}
	
	/**
	 * Método que realiza una consulta a la BBDD, lista todas las promociones genéricas y devuelve la lista en formato JSON
	 * @return List<Promocion> - lista de todas las promociones
	 */
	@RequestMapping(value="getGenericPromos", method=RequestMethod.GET)
	public @ResponseBody ListaPromosJSON getGenericPromos() {
		//Obtenemos la lista entera de promociones del método que tenemos en DatabaseMarkDirect
		List<Promocion> promoList = db.allGenericPromos();
		ListaPromosJSON listaJSON = new ListaPromosJSON(Promocion.convertJSON(promoList));
		return listaJSON;
	}
	
	/**
	 * Método que envía ofertas a la app móvil en función de los parámetros recibidos
	 * @param promoGen - género del usuario
	 * @param userAge - edad del usuario
	 * @param controlzoneMajor - major del beacon
	 * @param controlzoneMinor - minor del beacon
	 * @return List<Promocion> - lista de las promociones que le corresponden al usuario según sus características y su localización
	 */
	@RequestMapping(value="getPromos", method=RequestMethod.GET)
	public @ResponseBody ListaPromosJSON getPromos(@RequestParam("sex") String promoGen, @RequestParam("age") int userAge, @RequestParam("major") String controlzoneMajor, @RequestParam("minor") String controlzoneMinor) {
		System.out.println("Estoy en el método getPromos");
		List<Promocion> promoList = null;
		ListaPromosJSON listaJSON = null;
		/*Si el major y minor son caracteres vacíos, significa que la promoción es genérica */
		if(controlzoneMajor.equals("") && controlzoneMinor.equals("")) {
			promoList = db.filteredGenericPromos(promoGen, userAge);
			listaJSON = new ListaPromosJSON(Promocion.convertJSON(promoList));
		} else {
			promoList = db.listLocationPromos(promoGen, userAge, controlzoneMajor, controlzoneMinor);
			listaJSON = new ListaPromosJSON(Promocion.convertJSON(promoList));
		}
		return listaJSON;
	}
	
	//M�todo para registrar un usuario
		//En construccion
	@RequestMapping(value="registrousuario",method=RequestMethod.GET)
	public String registrousuario(){
		return "registroprueba";
	}
	
		@RequestMapping(value="registrarusuario" ,method=RequestMethod.POST)
		public @ResponseBody List<Usuario> registrarUser(
				@RequestParam("email") String email,@RequestParam("password") String password,
				@RequestParam("sex") String sex,@RequestParam("age") int age
				){
			List<Usuario> userlist=null;
			db.registrarusuario(email,password,sex,age);
			
			return userlist;
		}
}
