package com.markdirect.markdirect.beans;


public class Zona {
	
	//Variables
	private String nombre;
	private int telefono;
	private String direccion;
	private String descripcion;
	private String tipo;
	private String subtipo;
	private boolean activo;
	
	//Constructor
	public Zona(){};
	public Zona(String nombre, int telefono, String direccion, String descripcion, String tipo, String subtipo,
			boolean activo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.activo = activo;
	}
	
	//Metodos

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Zona [nombre=");
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
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
	
	
	

}