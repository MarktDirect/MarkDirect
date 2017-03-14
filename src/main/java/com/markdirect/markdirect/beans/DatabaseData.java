package com.markdirect.markdirect.beans;

public class DatabaseData {

	//Atributos
	private String dataName;
	private int dataValue;
	
	//Constructores
	public DatabaseData(){}
	
	public DatabaseData(String dataName, int dataValue) {
		super();
		this.dataName = dataName;
		this.dataValue = dataValue;
	}

	//Getters y seters
	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public int getDataValue() {
		return dataValue;
	}

	public void setDataValue(int dataValue) {
		this.dataValue = dataValue;
	}

	@Override
	public String toString() {
		return "DatabaseData [dataName=" + dataName + ", dataValue=" + dataValue + "]";
	}
	
	
	
}
