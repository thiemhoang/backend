package com.example.demo.dto.latest;

import com.example.demo.entity.Gps;

public class LatestGpsDto {

	private Long gpsId;
	private String name;
	private String description;
	private String iconPath;
	
	public LatestGpsDto(Gps gps) {
		this.gpsId = gps.getId();
		this.name = gps.getName();
		this.description = gps.getDescription();
		this.iconPath = gps.getImagePath();
	}

	public Long getGpsId() {
		return gpsId;
	}

	public void setGpsId(Long gpsId) {
		this.gpsId = gpsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
}
