package com.example.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.constant.Constants;
import com.example.dto.file.FileUploadResponseMessage;
import com.example.dto.gpx.Gpx;
import com.example.service.file.FileParserService;
import com.example.service.file.FilesStorageService;

@Service
public class GPSService {
	
	@Autowired
	private FilesStorageService filesStorageService;
	@Autowired
	private FileParserService fileParserService;
	
	private static final Logger LOGGER = Logger.getLogger(GPSService.class.getName());
	
	public FileUploadResponseMessage upload(MultipartFile file) {
		try {
			filesStorageService.save(file, Constants.USER_ID);
			Gpx gpx = fileParserService.parseGPX(file.getInputStream());
			gpx = gpx;
			return new FileUploadResponseMessage("Uploaded the file successfully:" + file.getOriginalFilename());
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Cannot upload file", e);
		}
		return new FileUploadResponseMessage("Could not upload the file: " + file.getOriginalFilename() + "!");
	}
	
	public void getLatestTrack() {
		
	}
	
	public void getDetail(String fileName) {
		
	}
}
