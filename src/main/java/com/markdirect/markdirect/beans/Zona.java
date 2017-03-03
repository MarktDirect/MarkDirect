package com.markdirect.markdirect.beans;


public class Zona {
	
	private int controlzoneId;
	private String controlzoneMajor;
	private String controlzoneMinor;
	private String controlzoneEmplacement;
	private int controlzone_centerId;
	
	public Zona() {}
	
	public Zona(int controlzoneId, String controlzoneMajor, String controlzoneMinor, String controlzoneEmplacement,
			int controlzone_centerId) {
		super();
		this.controlzoneId = controlzoneId;
		this.controlzoneMajor = controlzoneMajor;
		this.controlzoneMinor = controlzoneMinor;
		this.controlzoneEmplacement = controlzoneEmplacement;
		this.controlzone_centerId = controlzone_centerId;
	}

	public int getControlzoneId() {
		return controlzoneId;
	}

	public void setControlzoneId(int controlzoneId) {
		this.controlzoneId = controlzoneId;
	}

	public String getControlzoneMajor() {
		return controlzoneMajor;
	}

	public void setControlzoneMajor(String controlzoneMajor) {
		this.controlzoneMajor = controlzoneMajor;
	}

	public String getControlzoneMinor() {
		return controlzoneMinor;
	}

	public void setControlzoneMinor(String controlzoneMinor) {
		this.controlzoneMinor = controlzoneMinor;
	}

	public String getControlzoneEmplacement() {
		return controlzoneEmplacement;
	}

	public void setControlzoneEmplacement(String controlzoneEmplacement) {
		this.controlzoneEmplacement = controlzoneEmplacement;
	}

	public int getControlzone_centerId() {
		return controlzone_centerId;
	}

	public void setControlzone_centerId(int controlzone_centerId) {
		this.controlzone_centerId = controlzone_centerId;
	}

	@Override
	public String toString() {
		return "Centros [controlzoneId=" + controlzoneId + ", controlzoneMajor=" + controlzoneMajor
				+ ", controlzoneMinor=" + controlzoneMinor + ", controlzoneEmplacement=" + controlzoneEmplacement
				+ ", centers_centerId=" + controlzone_centerId + "]";
	}
	
	
	

}