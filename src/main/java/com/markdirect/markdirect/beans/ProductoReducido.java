package com.markdirect.markdirect.beans;

public class ProductoReducido {

	//Atributos
	long id;
	String name;
	int id_level2Category;
	int id_level1Category;
	
	//Constructores
	public ProductoReducido(){}
	
	public ProductoReducido(long id, String name, int id_level2Category, int id_level1Category) {
		this.id = id;
		this.name = name;
		this.id_level2Category = id_level2Category;
		this.id_level1Category = id_level1Category;
	}

	//Getters/Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId_level2Category() {
		return id_level2Category;
	}

	public void setId_level2Category(int id_level2Category) {
		this.id_level2Category = id_level2Category;
	}

	public int getId_level1Category() {
		return id_level1Category;
	}

	public void setId_level1Category(int id_level1Category) {
		this.id_level1Category = id_level1Category;
	}

	//Métodos
	@Override
	public String toString() {
		return "ProductoReducido [id=" + id + ", name=" + name + ", id_level2Category=" + id_level2Category
				+ ", id_level1Category=" + id_level1Category + "]";
	}
	
}
