package com.markdirect.markdirect.controllers;

import java.util.List;


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

	//Metodo que muestra en el jsp una lista de los usuarios
	@RequestMapping(value = "usuarios", method=RequestMethod.GET)
	public ModelAndView usuarios() {
		ModelAndView mav = new ModelAndView();
		DatabaseMarkDirect usuario = new DatabaseMarkDirect();
		mav.setViewName("usuarios");
		mav.addObject("usuario",usuario.listarUsuarios());
		return mav;
	}

	//Metodo para bloquear los usuarios escogidos
	//En construccion
	//El try and catch pilla la excepcion del arraylist y ejecuta otro metodo solo para un usuario
	@RequestMapping(value="usuario",method=RequestMethod.POST)
	public ModelAndView Bloquearusuario(@RequestParam("bloquear") String userblock){
		ModelAndView mav=new ModelAndView();
		DatabaseMarkDirect usuario = new DatabaseMarkDirect();
		try{
			String separador=",";
			String[] usuariosbloqueados;
			usuariosbloqueados=userblock.split(separador);
			mav.addObject("usuario",usuario.BloquearUsuario(usuariosbloqueados));
			mav.addObject("mensaje", "usuario bloqueado con exito");
			mav.setViewName("usuarios");
		}
		catch(ArrayIndexOutOfBoundsException e){
			mav.addObject("usuario",usuario.BloquearUsuario(userblock));
			mav.addObject("mensaje", "usuario bloqueado con exito");
			mav.setViewName("usuarios");

		}


		return mav;

	}

}
