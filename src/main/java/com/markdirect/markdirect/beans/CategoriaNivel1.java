package com.markdirect.markdirect.beans;

public class CategoriaNivel1 {
	
	//Atributos
	int id;
	String categoria;
	int id_catNivel2;
	
	//Constructores
	public CategoriaNivel1(){}
	
	public CategoriaNivel1(int id, String categoria, int id_catNivel2) {
		this.id = id;
		this.categoria = categoria;
		this.id_catNivel2 = id_catNivel2;
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
	public int getId_catNivel2() {
		return id_catNivel2;
	}
	public void setId_catNivel2(int id_catNivel2) {
		this.id_catNivel2 = id_catNivel2;
	}
	
	//Métodos
	@Override
	public String toString() {
		return "CategoriaNivel1 [id=" + id + ", categoria=" + categoria + ", id_catNivel2=" + id_catNivel2 + "]";
	}
	
}
