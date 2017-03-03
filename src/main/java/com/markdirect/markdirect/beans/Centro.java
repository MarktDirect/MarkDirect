package com.markdirect.markdirect.beans;

public class Centro {

	private String centerSubtype;
	private String centerType ;
	private String centerDescription;
	private String centerDireccion;
	private String centerName;
	private String centerAddres;
	
	
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
	public String getCenterDireccion() {
		return centerDireccion;
	}
	public void setCenterDireccion(String centerDireccion) {
		this.centerDireccion = centerDireccion;
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
				+ centerDescription + ", centerDireccion=" + centerDireccion + ", centerName=" + centerName
				+ ", centerAddres=" + centerAddres + "]";
	}
	
}
