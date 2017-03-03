package com.markdirect.markdirect.beans;

public class Centro {

	//Atributos
	private String centerSubtype;
	private String centerType ;
	private String centerDescription;
	private String centerName;
	private String centerAddres;
	private int center_adminId;
	private int centerId;
	
	//Constructores
	public Centro(){
		
	}
	
	public Centro(String centerSubtype, String centerType, String centerDescription, String centerName,
			String centerAddres) {
		this.centerSubtype = centerSubtype;
		this.centerType = centerType;
		this.centerDescription = centerDescription;
		this.centerName = centerName;
		this.centerAddres = centerAddres;
		//TODO modificar la Id del administrador
		this.center_adminId=1;
	}

	
	
	public Centro(String centerSubtype, String centerType, String centerDescription, String centerName,
			String centerAddres, int center_adminId, int centerId) {
		this.centerSubtype = centerSubtype;
		this.centerType = centerType;
		this.centerDescription = centerDescription;
		this.centerName = centerName;
		this.centerAddres = centerAddres;
		this.center_adminId = center_adminId;
		this.centerId = centerId;
	}

	//Geters and Seters
	public String getCenterSubtype() {
		return centerSubtype;
	}
	public void setCenterSubtype(String centerSubtype) {
		this.centerSubtype = centerSubtype;
	}
	public String getCenterType() {
		return centerType;
	}
	public void setCenterType(String centerType) {
		this.centerType = centerType;
	}
	public String getCenterDescription() {
		return centerDescription;
	}
	public void setCenterDescription(String centerDescription) {
		this.centerDescription = centerDescription;
	}
		public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddres() {
		return centerAddres;
	}
	public void setCenterAddres(String centerAddres) {
		this.centerAddres = centerAddres;
	}
	@Override
	public String toString() {
		return "Centro [centerSubtype=" + centerSubtype + ", centerType=" + centerType + ", centerDescription="
				+ centerDescription + ", centerName=" + centerName
				+ ", centerAddres=" + centerAddres + "]";
	}
	
}
