package com.markdirect.markdirect.beans;

public class CategoriaNivel1 {
	
	//Atributos
	int id;
	String category;
	int id_level2Category;
	
	//Constructores
	public CategoriaNivel1(){}
	
	public CategoriaNivel1(int id, String category, int id_level2Category) {
		this.id = id;
		this.category = category;
		this.id_level2Category = id_level2Category;
	}
	
	//Getters/Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getId_level2Category() {
		return id_level2Category;
	}
	public void setId_level2Category(int id_level2Category) {
		this.id_level2Category = id_level2Category;
	}
	
	//Métodos
	@Override
	public String toString() {
		return "CategoriaNivel1 [id=" + id + ", category=" + category + ", id_level2Category=" + id_level2Category + "]";
	}
	
}
