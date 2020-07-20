package com.example.demo.service.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.dao.GpsTrackDao;
import com.example.demo.dto.gpx.Gpx;
import com.example.demo.dto.gpx.Trkpt;
import com.example.demo.dto.gpx.Trkseg;
import com.example.demo.entity.GpsTrack;
import com.example.demo.util.DateUtils;

@Service
public class GpsTrackService {

	@Autowired
	private GpsTrackDao gpsTrackDao;
	
	public void saveGpsTrack(Long gpsId, Gpx gpxData) {
		List<Trkseg> trackSegs= gpxData.getTrk().getTrkseg();
		List<GpsTrack> trackPoints = new ArrayList<>();
		
		if(!CollectionUtils.isEmpty(trackSegs)) {
			for(Trkseg seg : trackSegs) {
				List<Trkpt> trackPts = seg.getTrkpt();
				if(!CollectionUtils.isEmpty(trackPts)) {
					trackPoints.addAll(
							trackPts.stream().map(trpt -> {
								GpsTrack trackPoint = new GpsTrack();
								trackPoint.setGpsId(gpsId);
								trackPoint.setTime(DateUtils.parseDate(trpt.getTime()));
								trackPoint.setLat(trpt.getLat());
								trackPoint.setLon(trpt.getLon());
								trackPoint.setEle(trpt.getEle());
								return trackPoint;
							}).collect(Collectors.toList())
					);
				}
			}
		}
		
		if(!trackPoints.isEmpty()) {
			gpsTrackDao.save(trackPoints);
		}
		
	}
	
	
	public List<GpsTrack> findByGpsId(Long gpsId) {
		return gpsTrackDao.findByGpsId(gpsId);
	}
}
