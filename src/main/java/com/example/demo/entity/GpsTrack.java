package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gps_track")
public class GpsTrack {
	
	public GpsTrack() {
		
	}
	
	public GpsTrack(Long gpsId, BigDecimal lat, BigDecimal lon, BigDecimal ele, Date createdDate) {
		super();
		this.gpsId = gpsId;
		this.lat = lat;
		this.lon = lon;
		this.ele = ele;
		this.createdDate = createdDate;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "gps_id", nullable = false)
	private Long gpsId;
	
	@Column(name = "lat", nullable = false, precision = 25, scale = 7)
	private BigDecimal lat;
	
	@Column(name = "lon", nullable = false, precision = 25, scale = 7)
	private BigDecimal lon;
	
	@Column(name = "ele", nullable = false, precision = 25, scale = 7)
	private BigDecimal ele;
	
	@Column(name = "time", nullable = false)
	private Date time;
	
	@Column(name = "created_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdDate;

	public Long getGpsId() {
		return gpsId;
	}

	public void setGpsId(Long gpsId) {
		this.gpsId = gpsId;
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

	public BigDecimal getEle() {
		return ele;
	}

	public void setEle(BigDecimal ele) {
		this.ele = ele;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
