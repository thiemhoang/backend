package com.example.service.file;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.example.dto.gpx.Gpx;


@Service
public class FileParserService {
	
	private static final Logger LOGGER = Logger.getLogger(FileParserService.class.getName()); 
	
	public Gpx parseGPX(InputStream stream) {
		try {
			JAXBContext jc = JAXBContext.newInstance(Gpx.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Gpx root = (Gpx) unmarshaller.unmarshal(stream);
			return root;
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Cannot parse gpx file", e);
		}
		return null;
	}
	
	
}
