package com.markdirect.markdirect.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
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
	@ResponseBody
	public List<Promocion> allPromos() {
		//Obtenemos la lista entera de promociones del método que tenemos en DatabaseMarkDirect
		List<Promocion> promociones = db.listarPromociones();
		return promociones;
	}
	
	
	
}
