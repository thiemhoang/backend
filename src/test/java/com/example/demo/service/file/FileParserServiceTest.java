package com.example.demo.service.file;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.demo.dto.gpx.Gpx;

/**
* @see com.example.demo.service.file.FileParserService
* @author tim.hoang
*
*/

@RunWith(MockitoJUnitRunner.class)
public class FileParserServiceTest {

	FileParserService service  = new FileParserService();
	
	@Test
	public void testParseGPX() throws FileNotFoundException {
		Gpx gpx = service.parseGPX(new FileInputStream(new File("src/test/resources/sample.gpx")));
		assertEquals(BigDecimal.valueOf(42.2205377), gpx.getWpt().get(0).getLat());
		
	}
}
