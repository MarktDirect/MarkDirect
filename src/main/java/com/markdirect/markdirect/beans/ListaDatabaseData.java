package com.markdirect.markdirect.beans;

import java.util.ArrayList;

public class ListaDatabaseData {

	private ArrayList<String> cols;
	private ArrayList<String> rows;
	
	public ListaDatabaseData() {}
	
	public ListaDatabaseData(ArrayList<String> cols, ArrayList<String> rows) {
		super();
		this.cols = cols;
		this.rows = rows;
	}



	public ArrayList<String> getCols() {
		return cols;
	}



	public void setCols(ArrayList<String> cols) {
		this.cols = cols;
	}



	public ArrayList<String> getRows() {
		return rows;
	}



	public void setRows(ArrayList<String> rows) {
		this.rows = rows;
	}



	@Override
	public String toString() {
		return "ListaDatabaseData [cols=" + cols + ", rows=" + rows + "]";
	}

	
	
}
