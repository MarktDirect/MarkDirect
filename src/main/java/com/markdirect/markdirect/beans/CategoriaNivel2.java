package com.markdirect.markdirect.beans;

public class CategoriaNivel2 {

	//Atributos
	int id;
	String category;
	
	//Constructores
	public CategoriaNivel2(){}
	
	public CategoriaNivel2(int id, String category) {
		this.id = id;
		this.category = category;
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

	//Métodos
	@Override
	public String toString() {
		return "CategoriaNivel2 [id=" + id + ", category=" + category + "]";
	}
	
}
