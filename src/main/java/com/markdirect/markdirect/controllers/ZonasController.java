package com.markdirect.markdirect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markdirect.markdirect.database.DatabaseMarkDirect;

@Controller
public class ZonasController {

	DatabaseMarkDirect db = new DatabaseMarkDirect();

	@RequestMapping(value="zonas", method = RequestMethod.GET)
	public ModelAndView zonas(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaZonas", db.listarZonas());
		mav.setViewName("centroszonas");
		return mav;
	}

	//método para añadir zonas
	/**
	 * This method calls to insertarZonaControl inserting the @RequestParam of the form as parameters
	 * @param controlzoneMajor
	 * @param controlzoneMinor
	 * @param controlzoneEmplacement
	 * @param controlzone_centerId
	 * @return the new ModelAndView
	 */
	@RequestMapping(value="zonas", method = RequestMethod.POST)
	public ModelAndView addZonas(
			@RequestParam("controlzoneMajor") String controlzoneMajor,
			@RequestParam("controlzoneMinor") String controlzoneMinor,
			@RequestParam("controlzoneEmplacement") String controlzoneEmplacement
			){

		//insertar zona de control en BBDD
		int algodon = db.insertarZonaControl(controlzoneMajor, controlzoneMinor, controlzoneEmplacement);

		//Vista
		ModelAndView mav = new ModelAndView();
		if(algodon == 1){
			mav.addObject("mensaje", "Zona de control cargada con Exito");
			mav.addObject("listaZonas", db.listarZonas());
			mav.setViewName("centroszonas");
		}else{
			mav.addObject("mensaje", "Error al cargar la zona de control");
			mav.addObject("listaZonas", db.listarZonas());
			mav.setViewName("centroszonas");
		}

		return mav;

	}


	/**
	 * Metodo para editar las zonas se recogen los parametros y se envian a un metodo que lo conecta con la BD
	 * @param idzona
	 * @param controlzoneEmplacement
	 * @param controlzoneMajor
	 * @param controlzoneMinor
	 * @return devuelve un mav con la lista de zonas modificada 
	 */
	@RequestMapping(value="editzonas", method=RequestMethod.POST)
	public ModelAndView editZonas(@RequestParam("controlzoneId")int idzona,
			@RequestParam("controlzoneEmplacement") String controlzoneEmplacement,
			@RequestParam("controlzoneMajor") String controlzoneMajor,
			@RequestParam("controlzoneMinor") String controlzoneMinor){

		int zonaeditada = db.editarZonaControl(idzona,controlzoneMajor, controlzoneMinor, controlzoneEmplacement);
		ModelAndView mav = new ModelAndView();
		if(zonaeditada == 1){
			mav.addObject("mensaje", "Zona de control editada con Exito");
			mav.addObject("listaZonas", db.listarZonas());
			mav.setViewName("centroszonas");
		}else{
			mav.addObject("mensaje", "Error al editar la zona de control");
			mav.addObject("listaZonas", db.listarZonas());
			mav.setViewName("centroszonas");
		}

		return mav;	
	}


	/**
	 *Metodo para eliminar las zonas segun la id enviada 
	 * @param idzona
	 * @return devuelve un mav con la lista de zonas editada
	 */
	@RequestMapping(value="deletezonas", method=RequestMethod.POST)
	public ModelAndView deleteZonas(@RequestParam("controlzoneid")int idzona){

		int zonaeliminada = db.eliminarZonaControl(idzona);
		ModelAndView mav = new ModelAndView();
		if(zonaeliminada == 1){
			mav.addObject("mensaje", "Zona de control eliminada con Exito");
			mav.addObject("listaZonas", db.listarZonas());
			mav.setViewName("centroszonas");
		}else{
			mav.addObject("mensaje", "Error al eliminar la zona de control");
			mav.addObject("listaZonas", db.listarZonas());
			mav.setViewName("centroszonas");
		}

		return mav;	
	}

}
