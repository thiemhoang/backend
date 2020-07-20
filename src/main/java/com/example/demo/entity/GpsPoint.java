package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gps_point")
public class GpsPoint {
	
	public GpsPoint() {
		
	}

	public GpsPoint(Long gpsId, String name, BigDecimal lat, BigDecimal lon) {
		super();
		this.gpsId = gpsId;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}


	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "gps_id", nullable = false)
	private Long gpsId;
	
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	
	@Column(name = "lat", nullable = false, precision = 25, scale = 7)
	private BigDecimal lat;
	
	@Column(name = "lon", nullable = false, precision = 25, scale = 7)
	private BigDecimal lon;
	
	@Column(name = "created_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdDate;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
