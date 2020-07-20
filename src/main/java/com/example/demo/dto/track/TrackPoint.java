package com.example.demo.dto.track;

import java.math.BigDecimal;

import com.example.demo.entity.GpsTrack;

public class TrackPoint {

	
	public TrackPoint(GpsTrack track) {
		this.lon = track.getLon();
		this.lat = track.getLat();
		this.ele = track.getEle();
	}
	
	private BigDecimal lat;
	private BigDecimal lon;
	private BigDecimal ele;

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

	public BigDecimal getEle() {
		return ele;
	}

	public void setEle(BigDecimal ele) {
		this.ele = ele;
	}

}
