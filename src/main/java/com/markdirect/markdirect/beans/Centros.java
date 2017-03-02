package com.markdirect.markdirect.beans;

public class Centros {

	private String nombre;
	private String telefono;
	private String direccion;
	private String descripcion;
	private String tipo;
	private String subtipo;
	private String activo;
	private String verCentro;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSubtipo() {
		return subtipo;
	}
	public void setSubtipo(String subtipo) {
		this.subtipo = subtipo;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getVerCentro() {
		return verCentro;
	}
	public void setVerCentro(String verCentro) {
		this.verCentro = verCentro;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Centros [nombre=");
		builder.append(nombre);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", subtipo=");
		builder.append(subtipo);
		builder.append(", activo=");
		builder.append(activo);
		builder.append(", verCentro=");
		builder.append(verCentro);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
