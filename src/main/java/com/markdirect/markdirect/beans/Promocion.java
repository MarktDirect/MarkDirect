package com.markdirect.markdirect.beans;


public class Promocion {
	
	//Variables
	private String nombre;
	private String descripcion;
	private String desde;
	private String hasta;
	private boolean activo;
	private String creado;
	
	//Constructor
	public Promocion(){}
	public Promocion(String nombre, String descripcion, String desde, String hasta, boolean activo, String creado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.desde = desde;
		this.hasta = hasta;
		this.activo = activo;
		this.creado = creado;
	}
	
	//Metodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde = desde;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getCreado() {
		return creado;
	}
	public void setCreado(String creado) {
		this.creado = creado;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Promocion [nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", desde=");
		builder.append(desde);
		builder.append(", hasta=");
		builder.append(hasta);
		builder.append(", activo=");
		builder.append(activo);
		builder.append(", creado=");
		builder.append(creado);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	

}
