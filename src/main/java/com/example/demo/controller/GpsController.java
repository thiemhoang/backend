package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.GpsService;

@RestController
@RequestMapping("/rest/gpx")
public class GpsController {
	
	@Autowired
	private GpsService gpsService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<?> uploadGpx(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		return new ResponseEntity<>(gpsService.upload(file), HttpStatus.OK);
	}

	@RequestMapping(value = "/getLastestTrack", method = RequestMethod.GET)
	public ResponseEntity<?> getLastesTrack(@RequestParam("page") Integer page) {
		
		return new ResponseEntity<>(gpsService.getLatestTrack(page), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET)
	public ResponseEntity<?> getDetail(@RequestParam("gpsId") Long gpsId) {
		return new ResponseEntity<>(gpsService.getDetail(gpsId), HttpStatus.OK);
	}
}
