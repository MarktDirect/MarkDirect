package com.markdirect.markdirect.beans;

import java.util.ArrayList;

public class ListaDatabaseData {

	private ArrayList<DatabaseData> data;

	
	
	
	public ListaDatabaseData(ArrayList<DatabaseData> data) {
		super();
		this.data = data;
	}

	
	
	
	public ArrayList<DatabaseData> getData() {
		return data;
	}




	public void setData(ArrayList<DatabaseData> data) {
		this.data = data;
	}




	@Override
	public String toString() {
		return "ListaDatabaseData [data=" + data + "]";
	}
	
	
}
