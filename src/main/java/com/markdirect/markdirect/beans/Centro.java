package com.markdirect.markdirect.beans;

public class Centro {

	private String subtipo;
	private String tipo ;
	private String descripción;
	private String dirección;
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
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	@Override
	public String toString() {
		return "Centro [subtipo=" + subtipo + ", tipo=" + tipo + ", descripción=" + descripción + ", dirección="
				+ dirección + ", Nombre=" + Nombre + "]";
	}
	
		
}
