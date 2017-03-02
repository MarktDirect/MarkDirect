package com.markdirect.markdirect.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//Controlador ocupado de dar validacion al usuario
@Controller


public class LoginController {

	//Metodo para comprobar si el usuario es valido o no
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView Validar(
			@RequestParam("admin") String usuario, 
			@RequestParam("adminPassword") String password) {
		ModelAndView mav = new ModelAndView();

		if(usuario.equals("admin") && password.equals("12345")){
			mav.setViewName("home");
		}else{
			mav.addObject("mensajeerror", "Usuario y/o contrase�a ya existen");
			mav.setViewName("login");
		}

		//Aqui abajo esta el metodo de loguear usuario con la base de datos
		//Comentado de momento
		
		/*  JdbcTemplate db= new JdbcTemplate(Conector.getDataSource());
		 * try{
		 * String sql = "SELECT*FROM USUARIOS WHERE USER= '" + usuario + "' AND PASS='" + password + "'"; Usuarios de momento puede cambiar el nombre
		 * List<Usuario> usuarios = db.query(sql,new BeanPropertyRowMapper<Usuario>(Usuario.class));
		 * if(!usuario.get(0).equals("")){
					mav.setViewName("home");
				}
				}
				
				catch(IndexOutOfBoundsException e) {
				mav.addObject("mensajeerror", "Usuario y/o Usuario y/o contrase�a no son correctos");
				mav.setViewName ("login");
			}  
		 */


		return mav;
	}

}
