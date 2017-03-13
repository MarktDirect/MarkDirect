package com.markdirect.markdirect.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.markdirect.markdirect.beans.ListaPromosJSON;
import com.markdirect.markdirect.beans.PromoJSON;
import com.markdirect.markdirect.beans.CategoriaNivel1;
import com.markdirect.markdirect.beans.CategoriaNivel2;
import com.markdirect.markdirect.beans.Producto;
import com.markdirect.markdirect.beans.ProductoReducido;

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
		List<Promocion> promoList = null;
		ListaPromosJSON listaJSON = null;
		/*Si el major y minor son caracteres vacíos, significa que la promoción es genérica */
		if(controlzoneMajor.equals("") && controlzoneMinor.equals("")) {
			promoList = db.getGenericPromos(token);
			if(!promoList.equals(null)) {
				listaJSON = new ListaPromosJSON(Promocion.convertJSON(promoList));
			} else {
				listaJSON = null;
			}
		} else {
			promoList = db.listLocationPromos(token, controlzoneMajor, controlzoneMinor);
			if(!promoList.equals(null)) { 
				listaJSON = new ListaPromosJSON(Promocion.convertJSON(promoList));
			} else {
				listaJSON = null;
			}
		}
		return listaJSON;
	}

	//Metodo que me lleva a una peque�a pagina para probar el registro de usuario
	//luego se puede eliminar
	@RequestMapping(value="registrousuario",method=RequestMethod.GET)
	public String registrousuario(){
		return "registroprueba";

	}

	/**
	 * Metodo para registrar el usuario en la BD
	 * Y si se ha registrado bien a�adirle un token en caso que el email exista
	 * Se comprobara si el usuario viene de facebook o manual en caso de venir de facebook se le devolvera su token
	 * y si intenta registrarse de nuevo manualmente y ya existe se le devolvera un token vacio
	 * @param email
	 * @param password
	 * @param sex
	 * @param age
	 * @param socialNetwork
	 * @return devuelve el string token al usuario registrado en caso de ser de FACEBOOK le devuelve su token
	 */
	@RequestMapping(value="registrarusuario" ,method=RequestMethod.POST)
	public @ResponseBody String  registrarUser(
			@RequestParam("email") String email,@RequestParam("password") String password,
			@RequestParam("sex") String sex,@RequestParam("age") int age, @RequestParam("socialNetwork") String socialNetwork
			){
		List<Map<String, Object>> tokendevuelto = null;
		db.idmaxUsuario();
		List<Map<String, Object>> tokenuser=null;
		String stringToken = "";
		String sentToken = "";
		try{
			if(db.registrarUsuario(email,password,sex,age, socialNetwork) == 1) {
				int idusermax=db.idmaxUsuario();
				//si se ha registrado correctamente, generamos un token para el usuario
				String token = UUID.randomUUID().toString();
				tokendevuelto=db.insertarToken(idusermax,token);
				for (Map<String, Object> map : tokendevuelto) {
					stringToken = map.toString();
					sentToken = stringToken.substring(7, stringToken.length()-1);
				}
			}
		}
		//Aqui se captura si el email del usuario ya existe y en caso de que exista se mirara
		//si viene por FACEBOOK o MANUAL,si viene por FACEBOOK se le dara su token y si no se le enviara token vacio
		catch (DuplicateKeyException e){
			if(db.socialNetwork(email).equals("FACEBOOK")){
				int idusuario=0;
				idusuario=db.comprobarEmail(email);
				tokenuser=db.sacarTokenUserLogin(idusuario);
				for(Map<String, Object> map : tokenuser){
					stringToken = map.toString();
					sentToken = stringToken.substring(7,stringToken.length()-1);
				}			
			}else{
				if(db.socialNetwork(email).equals("MANUAL")){
					sentToken="";
				}
			}
		}
		return sentToken;
	}

	/**
	 * Método que devuelve un Json via web con todas las Categorías de nivel2
	 * @return List<CategoriaNivel2> lista de categorías de nivel 2
	 */
	@RequestMapping(value="getCatNiv2", method=RequestMethod.GET)
	public @ResponseBody List<CategoriaNivel2> getCatNiv2(){
		List<CategoriaNivel2> catNiv2List = db.listarCategoriasNivel2();
		return catNiv2List;
	}

	/**
	 * Método que devuelve un Json via web con todas las Categorías de nivel1
	 * @return List<CategoriaNivel2> lista de categorías de nivel 1
	 */
	@RequestMapping(value="getCatNiv1", method=RequestMethod.GET)
	public @ResponseBody List<CategoriaNivel1> getCatNiv1(){
		List<CategoriaNivel1> catNiv1List = db.listarCategoriasNivel1();
		return catNiv1List;
	}
	/**
	 * Método que devuelve un Json via web con todos los productos
	 * @return List<Producto> lista de productos
	 */
	@RequestMapping(value="getProductos", method=RequestMethod.GET)
	public @ResponseBody List<Producto> getProductos(){
		List<Producto> productosList = db.listarProductos();
		return productosList;
	}

	/**
	 * Método que devuelve un Json con la lista de productos, pero sólo los campos id, nombre, cat2 y cat1
	 * @return List<ProductoReducido> lista de productos con menos categorias
	 */
	@RequestMapping(value="getProductosRed", method=RequestMethod.GET)
	public @ResponseBody List<ProductoReducido> getProductosReducidos(){
		List<ProductoReducido> poductosReducidosList = db.listarProductosReducidos();
		return poductosReducidosList;
	}


	//Metodo que lleva a un login de usuario de prueba para conectar con la app
	@RequestMapping(value="loginusuario",method=RequestMethod.GET)
	public String loguearousuario(){
		return "loginuserprueba";

	}


	/**
	 * Metodo para loguear usuario
	   El try and catch hace que devuelva un token vacio en caso de equivocarse con el email o el password
	 * @param email
	 * @param password
	 * @return devuelve un string json del token del usuario
	 */
	@RequestMapping(value="loginuser", method=RequestMethod.POST)
	public @ResponseBody String loginUser(@RequestParam("email") String email, @RequestParam("password") String password){
		List<Map<String, Object>> tokenuser= null;
		String stringToken="";
		String enviarToken="";
		int idusuario=0;
		try{
			idusuario=db.userLogin(email, password);
			tokenuser=db.sacarTokenUserLogin(idusuario);
			for(Map<String, Object> map : tokenuser){
				stringToken = map.toString();
				enviarToken = stringToken.substring(7,stringToken.length()-1);
				System.out.println(enviarToken);
			}
		}catch(EmptyResultDataAccessException e){
			System.out.println("Email o contrase�a mal");
		}
		return enviarToken;
	}
}
