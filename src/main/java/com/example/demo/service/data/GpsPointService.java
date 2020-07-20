package com.example.demo.service.data;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.dao.GpsPointDao;
import com.example.demo.dto.gpx.Gpx;
import com.example.demo.dto.gpx.Wpt;
import com.example.demo.entity.GpsPoint;

@Service
public class GpsPointService {
	
	@Autowired
	private GpsPointDao gpsPointDao;

	public void saveGpsPoint(Long gpsId, Gpx gpxData) {
		List<Wpt> points = gpxData.getWpt();
		if(!CollectionUtils.isEmpty(points)) {
			List<GpsPoint> gpsPoints = points.stream().map(wpt -> {
				GpsPoint point = new GpsPoint();
				point.setGpsId(gpsId);
				point.setName(wpt.getName());
				point.setLat(wpt.getLat());
				point.setLon(wpt.getLon());
				
				return point;
			}).collect(Collectors.toList());
			
			gpsPointDao.save(gpsPoints);
		}
	}
	
	public List<GpsPoint> findByGpsId(Long gpsId) {
		return gpsPointDao.findByGpsId(gpsId);
	}
}
