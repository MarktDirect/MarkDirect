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

	//Metodo que muestra en el jsp una lista de los usuarios 
	@RequestMapping(value = "usuarios", method=RequestMethod.GET)
	public ModelAndView usuarios() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios");
		mav.addObject("usuario",usuario.listarUsuarios());//Aqui se llama a un metodo en otro controlador que trae la lista
		return mav;
	}

	//Metodo para bloquear los usuarios escogidos
	//El try and catch pilla la excepcion del arraylist y ejecuta otro metodo solo para un usuario
	@RequestMapping(value="usuario",method=RequestMethod.POST)
	public ModelAndView bloquearUsuario(@RequestParam("bloquear") String userblock){
		ModelAndView mav=new ModelAndView();
		try{//Aqui coge una lista de bloqueados y las convierte en un array y bloquea los distintos usuarios
			String separador=",";
			String[] usuariosbloqueados;
			usuariosbloqueados=userblock.split(separador);
			mav.addObject("usuario",usuario.bloquearUsuario(usuariosbloqueados));//Metodo que bloqueara al usuario
			mav.addObject("mensaje", "usuario bloqueado con exito");
			mav.setViewName("usuarios");
		}
		catch(ArrayIndexOutOfBoundsException e){//En caso de que solo haya un usuario a bloquear ejecuta el catch
			mav.addObject("usuario",usuario.bloquearUsuario(userblock));//Metodo que bloqueara al usuario
			mav.addObject("mensaje", "usuario bloqueado con exito");
			mav.setViewName("usuarios");

		}
		mav.addObject("usuario",usuario.listarUsuarios());
		return mav;
	}
	
	
		
	

}
