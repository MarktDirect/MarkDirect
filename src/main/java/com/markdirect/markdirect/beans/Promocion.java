package com.markdirect.markdirect.beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Promocion {
	
	//Atributos
	private int promoId;
	private String promoName;
	private String promoDescription;
	private String promoSince;
	private String promoTo;
	private int promoState;
	private String promoCreate;
	private String promoImage;
	private int promoMinAge;
	private int promoMaxAge;
	private String promoGen;
	private int promo_controlzoneId;
	
	//Constructores
	public Promocion(){}
	public Promocion(String promoName, String promoDescription, String promoSince, String promoTo,
			String promoImage, int promoMinAge, int promoMaxAge,
			String promoGen, int promo_controlzoneId) {
		this.promoName = promoName;
		this.promoDescription = promoDescription;
		this.promoSince = promoSince;
		this.promoTo = promoTo;
		this.promoState = this.activePromo();
		this.promoCreate = Promocion.dateTimePromo();
		this.promoImage = promoImage;
		this.promoMinAge = promoMinAge;
		this.promoMaxAge = promoMaxAge;
		this.promoGen = promoGen;
		this.promo_controlzoneId = promo_controlzoneId;
	}
	
	

	public Promocion(int promoId, String promoName, String promoDescription, String promoSince, String promoTo,
			int promoState, String promoCreate, String promoImage, int promoMinAge, int promoMaxAge, String promoGen,
			int promo_controlzoneId) {
		super();
		this.promoId = promoId;
		this.promoName = promoName;
		this.promoDescription = promoDescription;
		this.promoSince = promoSince;
		this.promoTo = promoTo;
		this.promoState = promoState;
		this.promoCreate = promoCreate;
		this.promoImage = promoImage;
		this.promoMinAge = promoMinAge;
		this.promoMaxAge = promoMaxAge;
		this.promoGen = promoGen;
		this.promo_controlzoneId = promo_controlzoneId;
	}
	
	//Getters/Setters
	public int getPromoId() {
		return promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
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

	public int getPromoState() {
		return promoState;
	}

	public void setPromoState(int promoState) {
		this.promoState = promoState;
	}

	public String getPromoCreate() {
		return promoCreate;
	}

	public void setPromoCreate(String promoCreate) {
		this.promoCreate = promoCreate;
	}

	public String getPromoImage() {
		return promoImage;
	}

	public void setPromoImage(String promoImage) {
		this.promoImage = promoImage;
	}

	public int getPromoMinAge() {
		return promoMinAge;
	}

	public void setPromoMinAge(int promoMinAge) {
		this.promoMinAge = promoMinAge;
	}

	public int getPromoMaxAge() {
		return promoMaxAge;
	}

	public void setPromoMaxAge(int promoMaxAge) {
		this.promoMaxAge = promoMaxAge;
	}

	public String getPromoGen() {
		return promoGen;
	}

	public void setPromoGen(String promoGen) {
		this.promoGen = promoGen;
	}

	public int getPromo_controlzoneId() {
		return promo_controlzoneId;
	}

	public void setPromo_controlzoneId(int promo_controlzoneId) {
		this.promo_controlzoneId = promo_controlzoneId;
	}

	//Métodos

	@Override
	public String toString() {
		return "Promocion [promoId=" + promoId + ", promoName=" + promoName + ", promoDescription=" + promoDescription
				+ ", promoSince=" + promoSince + ", promoTo=" + promoTo + ", promoState=" + promoState
				+ ", promoCreate=" + promoCreate + ", promoImage=" + promoImage + ", promoMinAge=" + promoMinAge
				+ ", promoMaxAge=" + promoMaxAge + ", promoGen=" + promoGen + ", promo_controlzoneId="
				+ promo_controlzoneId + "]";
	}
	
	/* TODO
	 * Método que calcula si la promoción está activa o no
	 */
	public int activePromo() {
		return 1;
	}
	
	/*
	 * Método que calcula la fecha actual para establecer la fecha en la que se ha creado la promoción
	 */
	public static String dateTimePromo() {
		Calendar calendar = new GregorianCalendar(); 
		
		String day, month, year, hour, minute, seconds;
		
		day = Integer.toString(calendar.get(Calendar.DATE));
		month = Integer.toString(calendar.get(Calendar.MONTH));
		year = Integer.toString(calendar.get(Calendar.YEAR));
		hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
		minute = Integer.toString(calendar.get(Calendar.MINUTE));
		seconds = Integer.toString(calendar.get(Calendar.SECOND));
		
		String date = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + seconds;
		
		return date;
	}
	
}