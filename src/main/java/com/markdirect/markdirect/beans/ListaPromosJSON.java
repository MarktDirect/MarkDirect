package com.markdirect.markdirect.beans;

import java.util.ArrayList;

public class ListaPromosJSON {
	private ArrayList<PromoJSON> ofertas;

	public ListaPromosJSON(ArrayList<PromoJSON> lista){
		//Inicializamos el atributo a la lista de promos preparada para JSON
		this.ofertas = lista;
	}
	
	public ArrayList<PromoJSON> getOfertas() {
		return ofertas;
	}

	public void setOfertas(ArrayList<PromoJSON> ofertas) {
		this.ofertas = ofertas;
	}
	

	public ArrayList<PromoJSON> convertJSON() {
		ArrayList<PromoJSON> ofertas = new ArrayList<PromoJSON>();
		
		return ofertas;
	}
	
}
