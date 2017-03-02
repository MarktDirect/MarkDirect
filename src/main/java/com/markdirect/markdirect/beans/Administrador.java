package com.markdirect.markdirect.beans;

public class Administrador {
	//Variables
	private String usuario;
	private String password;
	
	
	//Constructor
	public Administrador(){};
	public Administrador(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}
	
	//Metodos
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Administrador [usuario=");
		builder.append(usuario);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
