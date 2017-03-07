package com.markdirect.markdirect.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	 * Método que envía ofertas a la app móvil en función de los parámetros recibidos
	 * @param token - token que identifica unívocamente al usuario
	 * @param controlzoneMajor - major del beacon
	 * @param controlzoneMinor - minor del beacon
	 * @return List<Promocion> - lista de las promociones que le corresponden al usuario según sus características y su localización
	 */
	@RequestMapping(value="getPromos", method=RequestMethod.GET)
	public @ResponseBody ListaPromosJSON getPromos(@RequestParam("token") String token, @RequestParam("major") String controlzoneMajor, @RequestParam("minor") String controlzoneMinor) {
		System.out.println("Estoy en el método getPromos");
		List<Promocion> promoList = null;
		ListaPromosJSON listaJSON = null;
		/*Si el major y minor son caracteres vacíos, significa que la promoción es genérica */
		if(controlzoneMajor.equals("") && controlzoneMinor.equals("")) {
			promoList = db.getGenericPromos(token);
			listaJSON = new ListaPromosJSON(Promocion.convertJSON(promoList));
		} else {
			promoList = db.listLocationPromos(token, controlzoneMajor, controlzoneMinor);
			listaJSON = new ListaPromosJSON(Promocion.convertJSON(promoList));
		}
		return listaJSON;
	}
	
	//Metodo que me lleva a una peque�a pagina para probar el registro de usuario
	@RequestMapping(value="registrousuario",method=RequestMethod.GET)
	public String registrousuario(){
		return "registroprueba";
		
	}
	//Metodo para registrar el usuario en la BD
	//Y si se ha registrado bien a�adirle un token
		@RequestMapping(value="registrarusuario" ,method=RequestMethod.POST)
		public @ResponseBody List<Usuario> registrarUser(
				@RequestParam("email") String email,@RequestParam("password") String password,
				@RequestParam("sex") String sex,@RequestParam("age") int age
				){
			List<Usuario> userlist=null;
			db.idmaxUsuario();
			if(db.registrarUsuario(email,password,sex,age) == 1) {
				int idusermax=db.idmaxUsuario();
				//si se ha registrado correctamente, generamos un token para el usuario
				String token = UUID.randomUUID().toString();
				db.insertarToken(idusermax,token);	
			}
			
			return userlist;
		}
}
