package com.example.demo.dto.gpx;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.example.demo.jaxb.deserializer.BigDecimalAdapter;

public class Trkpt {
	
	private BigDecimal lat;
	
	private BigDecimal lon;
	
	private String time;
	
	private BigDecimal ele;
	
	@XmlAttribute
	@XmlJavaTypeAdapter(BigDecimalAdapter.class)  
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	
	@XmlAttribute
	@XmlJavaTypeAdapter(BigDecimalAdapter.class)  
	public BigDecimal getLon() {
		return lon;
	}
	public void setLon(BigDecimal lon) {
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
	@XmlJavaTypeAdapter(BigDecimalAdapter.class)  
	public BigDecimal getEle() {
		return ele;
	}
	public void setEle(BigDecimal ele) {
		this.ele = ele;
	}
	
}
