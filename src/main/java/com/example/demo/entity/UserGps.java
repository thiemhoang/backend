package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "user_gps")
@IdClass(UserGpsPrimaryKey.class)
public class UserGps {
	
	@Column(name = "user_id", nullable = false)
	@Id
	private Long userId;
	
	@Column(name = "gps_id", nullable = false)
	@Id
	private Long gpsId;
	
	@Column(name = "created_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdDate;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
