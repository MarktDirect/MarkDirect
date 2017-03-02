package com.markdirect.markdirect.beans;

public class Usuario {
	
	//Variables
	private String nombre;
	private String email;
	private String genero;
	private int edad;
	
	//Constructor
	public Usuario(){};
	public Usuario(String nombre, String email, String genero, int edad) {
		this.nombre = nombre;
		this.email = email;
		this.genero = genero;
		this.edad = edad;
	}
	
	//Metodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [nombre=");
		builder.append(nombre);
		builder.append(", email=");
		builder.append(email);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", edad=");
		builder.append(edad);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	

}
