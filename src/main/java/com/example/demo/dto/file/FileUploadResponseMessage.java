package com.example.demo.dto.file;

public class FileUploadResponseMessage {
	private String message;
	private Long gpsId;

	public FileUploadResponseMessage(String message) {
		this.message = message;
	}

	public FileUploadResponseMessage(String message, long gpsId) {
		this.message = message;
		this.gpsId = gpsId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getGpsId() {
		return gpsId;
	}

	public void setGpsId(Long gpsId) {
		this.gpsId = gpsId;
	}
}
