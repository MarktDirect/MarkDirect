package com.markdirect.markdirect.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.markdirect.markdirect.beans.Promocion;
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
	public @ResponseBody List<Promocion> getGenericPromos() {
		//Obtenemos la lista entera de promociones del método que tenemos en DatabaseMarkDirect
		List<Promocion> promociones = db.allGenericPromos();
		return promociones;
	}
	
	/**
	 * Método que realiza una consulta a la BBDD, lista todas las promociones genéricas filtradas
	 * por género y edad y devuelve la lista en formato JSON. Recibe los parámetros desde la url
	 * @return List<Promocion> - promociones que le corresponden en función al filtro realizado
	 */
	@RequestMapping(value="getFilteredGenericPromos/{promoGen}/{userAge}", method=RequestMethod.GET)
	public @ResponseBody List<Promocion> getFilteredGenericPromos(@PathVariable("promoGen") String promoGen, @PathVariable("userAge") int userAge) {
		//Obtenemos la lista entera de promociones del método que tenemos en DatabaseMarkDirect
		List<Promocion> promociones = db.filteredGenericPromos(promoGen, userAge);
		return promociones;
	}
	
	/**
	 * Método que realiza una consulta a la BBDD, lista todas las promociones especificas de localización
	 * en función a en qué zona se encuentra el usuario y sus características personales
	 */
	@RequestMapping(value="getLocationPromos/{controlzoneMajor}/{controlzoneMinor}/{userId}/{promoGen}/{userAge}", method=RequestMethod.GET)
	public @ResponseBody List<Promocion> getLocationPromos(@PathVariable("controlzoneMajor") int controlzoneMajor, @PathVariable("controlzoneMinor") int controlzoneMinor, @PathVariable("userId") String userId, @PathVariable("promoGen") String promoGen, @PathVariable("userAge") int userAge) {
		//Obtenemos la lista entera de promociones del método que tenemos en DatabaseMarkDirect
		System.out.println("entro por el requestmapping");
		List<Promocion> promociones = db.listLocationPromos(promoGen, userAge, controlzoneMajor, userId, controlzoneMinor);
		return promociones;
	}
	
}
