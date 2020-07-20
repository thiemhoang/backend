package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GpsPoint;

@Repository
public interface GpsPointDao extends CrudRepository<GpsPoint, Long> {
	
	@Query("Select new GpsPoint(gpsId, name, lat, lon) from GpsPoint where gpsId = ?1")
	public List<GpsPoint> findByGpsId(Long gpsId);
}
