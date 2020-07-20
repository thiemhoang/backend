package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GpsTrack;


@Repository
public interface GpsTrackDao extends CrudRepository<GpsTrack, Long> {

	@Query("Select new GpsTrack(gpsId, lat, lon, ele, createdDate) from GpsTrack where gpsId = ?1 order by id")
	public List<GpsTrack> findByGpsId(Long gpsId);
}
