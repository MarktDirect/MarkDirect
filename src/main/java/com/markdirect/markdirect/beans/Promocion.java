package com.markdirect.markdirect.beans;


public class Promocion {
	
	//Variables
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
	
	//Constructor
	public Promocion(){}

	
	
	public Promocion(int promoId, String promoName, String promoDescription, String promoSince, String promoTo,
			int promoState, String promoCreate, String promoImage, int promoMinAge, int promoMaxAge,
			String promoGen, int promo_controlzoneId) {
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

	public int isPromoState() {
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
	public boolean activePromo() {
		return false;
	}
	
	/* TODO
	 * Método que data el alta de la promoción
	 */
	public String dateTimePromo() {
		
		return "";
	}
	
}