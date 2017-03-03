package com.markdirect.markdirect.beans;

public class Usuario {
	
	//Variables
	private String userEmail;
	private String userGen;
	private String userBorn;
	
	//Constructor
	public Usuario(){}
	public Usuario(String userEmail, String userGen, String userBorn) {
		this.userEmail = userEmail;
		this.userGen = userGen;
		this.userBorn = userBorn;
	}
	
	//Metodos
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserGen() {
		return userGen;
	}
	public void setUserGen(String userGen) {
		this.userGen = userGen;
	}
	public String getUserBorn() {
		return userBorn;
	}
	public void setUserBorn(String userBorn) {
		this.userBorn = userBorn;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [userEmail=");
		builder.append(userEmail);
		builder.append(", userGen=");
		builder.append(userGen);
		builder.append(", userBorn=");
		builder.append(userBorn);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	

}
