package com.markdirect.markdirect.beans;

public class Centro {

	private int controlzoneId;
	private String controlzoneMajor;
	private String controlzoneMinor;
	private String controlzoneEmplacement;
	private int centers_centerId;
	
	public Centro(int controlzoneId, String controlzoneMajor, String controlzoneMinor, String controlzoneEmplacement,
			int centers_centerId) {
		super();
		this.controlzoneId = controlzoneId;
		this.controlzoneMajor = controlzoneMajor;
		this.controlzoneMinor = controlzoneMinor;
		this.controlzoneEmplacement = controlzoneEmplacement;
		this.centers_centerId = centers_centerId;
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

	public int getCenters_centerId() {
		return centers_centerId;
	}

	public void setCenters_centerId(int centers_centerId) {
		this.centers_centerId = centers_centerId;
	}

	@Override
	public String toString() {
		return "Centros [controlzoneId=" + controlzoneId + ", controlzoneMajor=" + controlzoneMajor
				+ ", controlzoneMinor=" + controlzoneMinor + ", controlzoneEmplacement=" + controlzoneEmplacement
				+ ", centers_centerId=" + centers_centerId + "]";
	}
	
	
}
