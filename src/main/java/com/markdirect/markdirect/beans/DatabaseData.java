package com.markdirect.markdirect.beans;

public class DatabaseData {

	//atributos
	private String dataName;
	private int dataValue;
	
	public DatabaseData(){}
	
	public DatabaseData(String dataName, int dataValue) {
		super();
		this.dataName = dataName;
		this.dataValue = dataValue;
	}

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
