package com.markdirect.markdirect.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.database.DatabaseMarkDirect;
import com.mysql.fabric.xmlrpc.base.Array;


//Controlador de la pagina de usuarios
@Controller
public class UsuariosController {

	//Aqui se crea el objeto usuario de la clase DataBaseMarkDirect que se ocupara de las consultas a la BD
	DatabaseMarkDirect usuario = new DatabaseMarkDirect();

	/**
	 *Metodo que muestra en el jsp una lista de los usuarios
	 * @return devuelve un mav en el que esta agregado el metodo para listar los usuarios y la pagina jsp a la que ir
	 */
	@RequestMapping(value = "usuarios", method=RequestMethod.GET)
	public ModelAndView usuarios() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios");
		mav.addObject("usuario",usuario.listarUsuarios());//Aqui se llama a un metodo en otro controlador que trae la lista
		return mav;
	}



	/**
	 * Metodo para bloquear los usuarios escogidos
	 *El try and catch pilla la excepcion del arraylist y ejecuta otro metodo solo para un usuario
	 * @param userblock
	 * @return devuelve un objeto mav al que esta añadido el metodo para bloquear usuario, un mensaje de exito y la pagina jsp a la que ir
	 */
	@RequestMapping(value="usuario",method=RequestMethod.POST)
	public ModelAndView bloquearUsuario(@RequestParam("bloquear") String userblock){
		ModelAndView mav=new ModelAndView();
		try{//Aqui coge una lista de bloqueados y las convierte en un array y bloquea los distintos usuarios
			String separador=",";
			String[] usuariosbloqueados;
			usuariosbloqueados=userblock.split(separador);
			mav.addObject("usuario",usuario.bloquearUsuario(usuariosbloqueados));//Metodo que bloqueara al usuario
			mav.addObject("mensajeblock", "usuario bloqueado con exito");
			mav.setViewName("usuarios");
		}
		catch(ArrayIndexOutOfBoundsException e){//En caso de que solo haya un usuario a bloquear ejecuta el catch
			mav.addObject("usuario",usuario.bloquearUsuario(userblock));//Metodo que bloqueara al usuario
			mav.addObject("mensajeblock", "usuario bloqueado con exito");
			mav.setViewName("usuarios");
		}
		mav.addObject("usuario",usuario.listarUsuarios());
		return mav;
	}

	/**
	 * Metodo para desbloquear usuario
	 * @param userdesblock
	 * @return devuelve una lista de los usuarios completa hecho los cambios de desbloqueo
	 */
	@RequestMapping(value="usuarios",method=RequestMethod.POST)
	public ModelAndView desBloquearUsuario(@RequestParam("desbloquear") String userdesblock){
		ModelAndView mav=new ModelAndView();
		try{//Aqui coge una lista de bloqueados y las convierte en un array y desbloquea los distintos usuarios
			String separador=",";
			String[] usuariosdesbloqueados;
			usuariosdesbloqueados=userdesblock.split(separador);
			mav.addObject("usuario",usuario.desbloquearUsuario(usuariosdesbloqueados));//Metodo que debloqueara al usuario
			mav.addObject("mensajedesblock", "usuario desbloqueado con exito");
			mav.setViewName("usuarios");
		}
		catch(ArrayIndexOutOfBoundsException e){//En caso de que solo haya un usuario a bloquear ejecuta el catch
			mav.addObject("usuario",usuario.desBloquearUsuario(userdesblock));//Metodo que bloqueara al usuario
			mav.addObject("mensajedesblock", "usuario desbloqueado con exito");
			mav.setViewName("usuarios");
		}
		mav.addObject("usuario",usuario.listarUsuarios());
		return mav;
	}





}
