package com.example.dto.gpx;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Trkpt {
	
	private double lat;
	
	private double lon;
	
	private String time;
	
	private double ele;
	
	@XmlAttribute
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	@XmlAttribute
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	@XmlElement
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@XmlElement
	public double getEle() {
		return ele;
	}
	public void setEle(double ele) {
		this.ele = ele;
	}
	
}
