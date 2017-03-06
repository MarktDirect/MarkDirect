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
	 * Método que envía ofertas a la app móvil en función de los parámetros recibidos
	 * @param promoGen - género del usuario
	 * @param userAge - edad del usuario
	 * @param controlzoneMajor - major del beacon
	 * @param controlzoneMinor - minor del beacon
	 * @return List<Promocion> - lista de las promociones que le corresponden al usuario según sus características y su localización
	 */
	@RequestMapping(value="getPromos?_sex={promoGen}?_age={userAge}?_minor={controlzoneMinor}?_major={controlzoneMajor}", method=RequestMethod.GET)
	public @ResponseBody List<Promocion> getPromos(@PathVariable("promoGen") String promoGen, @PathVariable("userAge") int userAge, @PathVariable("controlzoneMajor") String controlzoneMajor, @PathVariable("controlzoneMinor") String controlzoneMinor) {
		List<Promocion> promoList = null;
		/*Si el major y minor son caracteres vacíos, significa que la promoción es genérica */
		if(controlzoneMajor.equals("") && controlzoneMinor.equals("")) {
			promoList = db.filteredGenericPromos(promoGen, userAge);
		} else {
			promoList = db.listLocationPromos(promoGen, userAge, controlzoneMajor, controlzoneMinor);
		}
		return promoList;
	}
}
