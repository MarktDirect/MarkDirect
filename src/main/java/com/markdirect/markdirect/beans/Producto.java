package com.markdirect.markdirect.beans;

public class Producto {

	//Atributos
	private long id;
	private String nombre;
	private int id_catNivel2;
	private int id_catNivel1;
	private String marca;
	private int pvp;
	private String imagen;
	
	//Constructores
	public Producto(){}
	
	public Producto(long id, String nombre, int id_catNivel2, int id_catNivel1, String marca, int pvp, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.id_catNivel2 = id_catNivel2;
		this.id_catNivel1 = id_catNivel1;
		this.marca = marca;
		this.pvp = pvp;
		this.imagen = imagen;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPvp() {
		return pvp;
	}
	public void setPvp(int pvp) {
		this.pvp = pvp;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	//Métodos
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", id_catNivel2=" + id_catNivel2 + ", id_catNivel1="
				+ id_catNivel1 + ", marca=" + marca + ", pvp=" + pvp + ", imagen=" + imagen + "]";
	}
	
}
