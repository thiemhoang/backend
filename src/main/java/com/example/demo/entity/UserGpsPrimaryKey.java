package com.example.demo.entity;

import java.io.Serializable;

public class UserGpsPrimaryKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private Long gpsId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGpsId() {
		return gpsId;
	}

	public void setGpsId(Long gpsId) {
		this.gpsId = gpsId;
	}

}
