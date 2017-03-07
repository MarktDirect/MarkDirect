package com.markdirect.markdirect.beans;

public class ProductoReducido {

	//Atributos
	long id;
	String nombre;
	int id_catNivel2;
	int id_catNivel1;
	
	//Constructores
	public ProductoReducido(){}
	
	public ProductoReducido(long id, String nombre, int id_catNivel2, int id_catNivel1) {
		this.id = id;
		this.nombre = nombre;
		this.id_catNivel2 = id_catNivel2;
		this.id_catNivel1 = id_catNivel1;
	}

	//Getters/Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_catNivel2() {
		return id_catNivel2;
	}

	public void setId_catNivel2(int id_catNivel2) {
		this.id_catNivel2 = id_catNivel2;
	}

	public int getId_catNivel1() {
		return id_catNivel1;
	}

	public void setId_catNivel1(int id_catNivel1) {
		this.id_catNivel1 = id_catNivel1;
	}

	//Métodos
	@Override
	public String toString() {
		return "ProductoReducido [id=" + id + ", nombre=" + nombre + ", id_catNivel2=" + id_catNivel2
				+ ", id_catNivel1=" + id_catNivel1 + "]";
	}
	
}
