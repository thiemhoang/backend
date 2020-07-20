package com.example.demo.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.constant.Constants;
import com.example.demo.dto.GpsDetailsDto;
import com.example.demo.dto.ResponsePaginationDto;
import com.example.demo.dto.file.FileUploadResponseMessage;
import com.example.demo.dto.gpx.Gpx;
import com.example.demo.dto.latest.LatestGpsDto;
import com.example.demo.dto.track.TrackPoint;
import com.example.demo.dto.track.WayPoint;
import com.example.demo.entity.Gps;
import com.example.demo.entity.GpsPoint;
import com.example.demo.entity.GpsTrack;
import com.example.demo.service.data.GpsDataService;
import com.example.demo.service.file.FileParserService;
import com.example.demo.service.file.FilesStorageService;

@Service
public class GpsService {

	@Autowired
	private FilesStorageService filesStorageService;
	@Autowired
	private FileParserService fileParserService;
	@Autowired
	private GpsDataService gpsDataService;

	private static final Logger LOGGER = Logger.getLogger(GpsService.class.getName());

	public FileUploadResponseMessage upload(MultipartFile file) {
		try {
			long userId = ThreadLocalRandom.current().nextLong(0, 1000000);
			if (filesStorageService.exist(file, userId)) {
				return new FileUploadResponseMessage("File existed already!");
			}
			String fileName = filesStorageService.save(file, userId);
			Gpx gpxData = fileParserService.parseGPX(file.getInputStream());
			Long gpsId = gpsDataService.saveUploadData(gpxData, userId, fileName);

			return new FileUploadResponseMessage("Uploaded the file successfully:" + file.getOriginalFilename(), gpsId);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Cannot upload file", e);
		}
		return new FileUploadResponseMessage("Could not upload the file: " + file.getOriginalFilename() + "!");
	}

	public ResponsePaginationDto<LatestGpsDto> getLatestTrack(Integer page) {
		ResponsePaginationDto<LatestGpsDto> result = new ResponsePaginationDto<>();
		Page<Gps> pageResult = gpsDataService.findAllPaging(page);
		List<Gps> gpsEntities = pageResult.getContent();
		if(!CollectionUtils.isEmpty(gpsEntities)) {
			result.setData(gpsEntities.stream().map(gps -> new LatestGpsDto(gps)).collect(Collectors.toList()));
		}
		result.setCurrentPage(page);
		result.setRowsPerPage(Constants.ROWS_PER_PAGE);
		result.setTotalPage(pageResult.getTotalPages());
		
		return result;
	}

	public GpsDetailsDto getDetail(Long gpsId) {
		GpsDetailsDto result = new GpsDetailsDto();
		Gps gps = gpsDataService.getGpsById(gpsId);
		if(gps == null) {
			return null;
		}
		result.setGpxInfo(gps);
		
		List<GpsPoint> points = gpsDataService.findWayPoints(gpsId);
		
		if(!CollectionUtils.isEmpty(points)) {
			result.setPoints(points.stream().map(WayPoint::new).collect(Collectors.toList()));
		}
		
		List<GpsTrack> trackPoints = gpsDataService.findTrackPoint(gpsId);
		
		if(!CollectionUtils.isEmpty(trackPoints)) {
			result.setTrackPoint(trackPoints.stream().map(TrackPoint::new).collect(Collectors.toList()));
		}
		
		return result;
	}
}
