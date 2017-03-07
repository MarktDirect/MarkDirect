package com.markdirect.markdirect.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="getPromos", method=RequestMethod.GET)
	public @ResponseBody List<Promocion> getPromos(@RequestParam("sex") String promoGen, @RequestParam("age") int userAge, @RequestParam("major") String controlzoneMajor, @RequestParam("minor") String controlzoneMinor) {
		System.out.println("Estoy en el método getPromos");
		List<Promocion> promoList = null;
		/*Si el major y minor son caracteres vacíos, significa que la promoción es genérica */
		if(controlzoneMajor.equals("") && controlzoneMinor.equals("")) {
			promoList = db.filteredGenericPromos(promoGen, userAge);
		} else {
			promoList = db.listLocationPromos(promoGen, userAge, controlzoneMajor, controlzoneMinor);
		}
		return promoList;
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
			if(db.registrarUsuario(email,password,sex,age) == 1) {
				//si se ha registrado correctamente, generamos un token para el usuario
				String token = UUID.randomUUID().toString();
				
				
			}
			
			return userlist;
		}
}
