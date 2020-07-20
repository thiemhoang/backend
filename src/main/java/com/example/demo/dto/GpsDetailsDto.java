package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.track.TrackPoint;
import com.example.demo.dto.track.WayPoint;
import com.example.demo.entity.Gps;
import com.fasterxml.jackson.annotation.JsonFormat;

public class GpsDetailsDto {

	private Long id;
	private String name;
	private String description;
	private String filePath;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
	private Date addDate;
	private List<WayPoint> points;
	private List<TrackPoint> trackPoint;
	
	public void setGpxInfo(Gps gps) {
		this.id = gps.getId();
		this.name = gps.getName();
		this.filePath = gps.getFilePath();
		this.description = gps.getDescription();
		this.addDate = gps.getCreatedDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public List<WayPoint> getPoints() {
		return points;
	}

	public void setPoints(List<WayPoint> points) {
		this.points = points;
	}

	public List<TrackPoint> getTrackPoint() {
		return trackPoint;
	}

	public void setTrackPoint(List<TrackPoint> trackPoint) {
		this.trackPoint = trackPoint;
	}
}
