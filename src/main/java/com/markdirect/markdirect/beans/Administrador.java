package com.markdirect.markdirect.beans;

public class Administrador {
	//Variables
	private String admin;
	private String adminPassword;
	private String adminEmail;
	
	//Constructor
	public Administrador(){}
	public Administrador(String admin, String adminPassword, String adminEmail) {
		this.admin = admin;
		this.adminPassword = adminPassword;
		this.adminEmail = adminEmail;
	}
	
	//Metodos
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Administrador [admin=");
		builder.append(admin);
		builder.append(", adminPassword=");
		builder.append(adminPassword);
		builder.append(", adminEmail=");
		builder.append(adminEmail);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	

}
