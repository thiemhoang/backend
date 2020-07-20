package com.example.demo.dto.track;

import java.math.BigDecimal;

import com.example.demo.entity.GpsPoint;

public class WayPoint {
	
	public WayPoint(GpsPoint point) {
		this.name = point.getName();
		this.lat = point.getLat();
		this.lon = point.getLon();
	}

	private String name;
	private BigDecimal lat;
	private BigDecimal lon;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLon() {
		return lon;
	}
	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}
}
