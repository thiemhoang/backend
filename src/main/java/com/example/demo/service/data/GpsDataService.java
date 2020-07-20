package com.example.demo.service.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.constant.Constants;
import com.example.demo.dao.GpsDao;
import com.example.demo.dto.gpx.Gpx;
import com.example.demo.entity.Gps;
import com.example.demo.entity.GpsPoint;
import com.example.demo.entity.GpsTrack;

@Service
public class GpsDataService {

	@Autowired
	private GpsDao gpsDao;
	
	@Autowired
	private GpsPointService gpsPointService;
	
	@Autowired
	private GpsTrackService gpsTrackService;
	
	@Autowired
	private UserGpsService userGpsService;

	
	@Transactional
	public Long saveUploadData(Gpx gpxData, long userId, String filePath) {
		Long gpsId = saveGps(filePath, gpxData);
		gpsPointService.saveGpsPoint(gpsId, gpxData);
		gpsTrackService.saveGpsTrack(gpsId, gpxData);
		userGpsService.saveUserGps(gpsId, userId);
		return gpsId;
	}
	
	public Long saveGps(String filePath, Gpx gpxData) {
		Gps gps = new Gps();
		gps.setFilePath(filePath);
		gps.setName(gpxData.getMetadata().getName());
		gps.setDescription(gpxData.getMetadata().getDesc());
		gps.setImagePath("/image/icon.png");
		gpsDao.save(gps);
		return gps.getId();
	}
	
	public Page<Gps> findAllPaging(Integer page) {
		Pageable paging = new PageRequest(page, Constants.ROWS_PER_PAGE, new Sort(new Sort.Order(Direction.DESC, "id")));
		return gpsDao.findAll(paging);
	}
	
	public Gps getGpsById(Long id) {
		return gpsDao.findOne(id);
	}
	
	public List<GpsTrack> findTrackPoint(Long gpsId) {
		return this.gpsTrackService.findByGpsId(gpsId);
	}
	
	public List<GpsPoint> findWayPoints(Long gpsId) {
		return this.gpsPointService.findByGpsId(gpsId);
	}
}
