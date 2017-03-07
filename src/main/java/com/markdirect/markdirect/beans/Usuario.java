package com.markdirect.markdirect.beans;

public class Usuario {
	
	//Variables
	private String userEmail;
	private String userGen;
	private int userAge;
	private int userBlock;
	
	//Constructor
	public Usuario(){}
	public Usuario(String userEmail, String userGen, int userAge, int userBlock) {
		this.userEmail = userEmail;
		this.userGen = userGen;
		this.userAge = userAge;
		this.userBlock=userBlock;
	}
	
	public Usuario(String userGen, int userAge) {
		this.userGen = userGen;
		this.userAge = userAge;
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
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public int getUserBlock() {
		return userBlock;
	}
	public void setUserBlock(int userBlock) {
		this.userBlock = userBlock;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [userEmail=");
		builder.append(userEmail);
		builder.append(", userGen=");
		builder.append(userGen);
		builder.append(", userAge=");
		builder.append(userAge);
		builder.append(", userBlock=");
		builder.append(userBlock);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
	

}
