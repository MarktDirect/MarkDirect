package com.markdirect.markdirect.beans;

public class CategoriaNivel2 {

	//Atributos
	int id;
	String categoria;
	
	//Constructores
	public CategoriaNivel2(){}
	
	public CategoriaNivel2(int id, String categoria) {
		this.id = id;
		this.categoria = categoria;
	}

	//Getters/Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	//Métodos
	@Override
	public String toString() {
		return "CategoriaNivel2 [id=" + id + ", categoria=" + categoria + "]";
	}
	
}
