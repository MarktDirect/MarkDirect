package com.markdirect.markdirect.beans;


public class Promocion {
	
	//Variables
	private String promoName;
	private String promoDescription;
	private String promoSince;
	private String promoTo;
	private boolean promoState;
	private String promoCreate;
	
	//Constructor
	public Promocion(){}
	public Promocion(String promoName, String promoDescription, String promoSince, String promoTo, boolean promoState, String promoCreate) {
		super();
		this.promoName = promoName;
		this.promoDescription = promoDescription;
		this.promoSince = promoSince;
		this.promoTo = promoTo;
		this.promoState = promoState;
		this.promoCreate = promoCreate;
	}
	public String getPromoName() {
		return promoName;
	}
	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}
	public String getPromoDescription() {
		return promoDescription;
	}
	public void setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
	}
	public String getPromoSince() {
		return promoSince;
	}
	public void setPromoSince(String promoSince) {
		this.promoSince = promoSince;
	}
	public String getPromoTo() {
		return promoTo;
	}
	public void setPromoTo(String promoTo) {
		this.promoTo = promoTo;
	}
	public boolean isPromoState() {
		return promoState;
	}
	public void setPromoState(boolean promoState) {
		this.promoState = promoState;
	}
	public String getPromoCreate() {
		return promoCreate;
	}
	public void setPromoCreate(String promoCreate) {
		this.promoCreate = promoCreate;
	}
	@Override
	public String toString() {
		return "Promocion [promoName=" + promoName + ", promoDescription=" + promoDescription + ", promoSince="
				+ promoSince + ", promoTo=" + promoTo + ", promoState=" + promoState + ", promoCreate=" + promoCreate
				+ "]";
	}
	
	
}
	
	