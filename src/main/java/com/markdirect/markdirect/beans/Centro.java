package com.markdirect.markdirect.beans;

public class Centro {

	private String subtipo;
	private String tipo ;
	private String descripci�n;
	private String direcci�n;
	private String Nombre;
	public String getSubtipo() {
		return subtipo;
	}
	public void setSubtipo(String subtipo) {
		this.subtipo = subtipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripci�n() {
		return descripci�n;
	}
	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}
	public String getDirecci�n() {
		return direcci�n;
	}
	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	@Override
	public String toString() {
		return "Centro [subtipo=" + subtipo + ", tipo=" + tipo + ", descripci�n=" + descripci�n + ", direcci�n="
				+ direcci�n + ", Nombre=" + Nombre + "]";
	}
	
		
}
