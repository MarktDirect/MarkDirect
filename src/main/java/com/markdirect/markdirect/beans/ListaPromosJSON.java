package com.markdirect.markdirect.beans;

import java.util.ArrayList;
import java.util.List;

public class ListaPromosJSON {

	//Atributos
	private ArrayList<PromoJSON> ofertas;

	//Constructor
	public ListaPromosJSON(ArrayList<PromoJSON> lista){
		//Inicializamos el atributo a la lista de promos preparada para JSON
		this.ofertas = lista;
	}

	//Geter y seter
	public ArrayList<PromoJSON> getOfertas() {
		return ofertas;
	}

	public void setOfertas(ArrayList<PromoJSON> ofertas) {
		this.ofertas = ofertas;
	}

	@Override
	public String toString() {
		return "ListaPromosJSON [ofertas=" + ofertas + "]";
	}


}
