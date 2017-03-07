package com.markdirect.markdirect.beans;


public class PromoJSON {
	
	//Atributos
	private String titulo;
	private String validez;
	private String descripcion;
	private String imagen;
	
	//Constructores
	public PromoJSON(){}

	public PromoJSON(String titulo, String validez, String descripcion, String imagen) {
		this.titulo = titulo;
		this.validez = validez;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getValidez() {
		return validez;
	}

	public void setValidez(String validez) {
		this.validez = validez;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "PromoJSON [titulo=" + titulo + ", validez=" + validez + ", descripcion=" + descripcion + ", imagen="
				+ imagen + "]";
	}
	
	
	
}