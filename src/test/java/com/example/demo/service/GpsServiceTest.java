package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.GpsDetailsDto;
import com.example.demo.dto.ResponsePaginationDto;
import com.example.demo.dto.file.FileUploadResponseMessage;
import com.example.demo.dto.latest.LatestGpsDto;
import com.example.demo.entity.Gps;
import com.example.demo.entity.GpsPoint;
import com.example.demo.entity.GpsTrack;
import com.example.demo.service.data.GpsDataService;
import com.example.demo.service.file.FileParserService;
import com.example.demo.service.file.FilesStorageService;

/**
* @see com.example.demo.service.GpsService
* @author tim.hoang
*
*/

@RunWith(MockitoJUnitRunner.class)
public class GpsServiceTest {

	private static GpsService service = new GpsService();
	
	private static FilesStorageService filesStorageService;
	private static FileParserService fileParserService;
	private static GpsDataService gpsDataService;
	
	private static final String FILE_PATH = "filepath";
	
	private static MultipartFile file = new MultipartFile() {
		
		@Override
		public void transferTo(File dest) throws IOException, IllegalStateException {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public long getSize() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public String getOriginalFilename() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public InputStream getInputStream() throws IOException {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getContentType() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public byte[] getBytes() throws IOException {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	@Before
    public void init() {
		filesStorageService = mock(FilesStorageService.class);
		fileParserService = mock(FileParserService.class);
		gpsDataService = mock(GpsDataService.class);
		
		
		Whitebox.setInternalState(service, "filesStorageService", filesStorageService);
		Whitebox.setInternalState(service, "fileParserService", fileParserService);
		Whitebox.setInternalState(service, "gpsDataService", gpsDataService);
		
		when(filesStorageService.exist(any(), anyLong())).thenReturn(false);
		when(filesStorageService.save(any(), anyLong())).thenReturn(FILE_PATH);
		when(fileParserService.parseGPX(any())).thenReturn(null);
		when(gpsDataService.saveUploadData(any(), anyLong(), anyString())).thenReturn(1L);
		
	}
	
	@Test
	public void testUpload() {
		when(fileParserService.parseGPX(any())).thenReturn(null);
		FileUploadResponseMessage message = service.upload(file);
		assertEquals(message.getGpsId().longValue(), 1L);
	}
	
	@Test
	public void testUploadException() {
		when(fileParserService.parseGPX(any())).thenThrow(new RuntimeException());
		FileUploadResponseMessage message = service.upload(file);
		assertNull(message.getGpsId());
		assertTrue(message.getMessage().contains("Could not upload the file"));
	}
	
	
	@Test
	public void testGetDetail() {
		when(gpsDataService.getGpsById(anyLong())).thenReturn(null);
		GpsDetailsDto result = service.getDetail(1L);
		assertNull(result);
	}
	
	@Test
	public void testGetDetailNull() {
		Gps gps = new Gps();
		gps.setName("a");
		when(gpsDataService.getGpsById(anyLong())).thenReturn(gps);
		when(gpsDataService.findWayPoints(anyLong())).thenReturn(null);
		when(gpsDataService.findTrackPoint(anyLong())).thenReturn(null);
		
		GpsDetailsDto result = service.getDetail(1L);
		assertEquals("a", result.getName());
	}
	
	
	@Test
	public void testGetDetailOk() {
		Gps gps = new Gps();
		gps.setName("a");
		
		List<GpsTrack> trackPoints = new ArrayList<>();
		trackPoints.add(new GpsTrack(1L, BigDecimal.valueOf(1.2), BigDecimal.valueOf(1.2), BigDecimal.valueOf(1.2), new Date()));
		
		List<GpsPoint> wayPoints = new ArrayList<>();
		wayPoints.add(new GpsPoint(1L, "point", BigDecimal.valueOf(1.2), BigDecimal.valueOf(1.2)));
		
		when(gpsDataService.getGpsById(anyLong())).thenReturn(gps);
		when(gpsDataService.findWayPoints(anyLong())).thenReturn(wayPoints);
		when(gpsDataService.findTrackPoint(anyLong())).thenReturn(trackPoints);
		
		GpsDetailsDto result = service.getDetail(1L);
		assertEquals("point", result.getPoints().get(0).getName());
		assertEquals(BigDecimal.valueOf(1.2), result.getTrackPoint().get(0).getLon());
	}
	
	
	@Test
	public void testGetLatestTrackNoRecord() {
		Page<Gps> page = new Page<Gps>() {
			
			@Override
			public Iterator<Gps> iterator() {
				return null;
			}
			
			@Override
			public Pageable previousPageable() {
				return null;
			}
			
			@Override
			public Pageable nextPageable() {
				return null;
			}
			
			@Override
			public boolean isLast() {
				return false;
			}
			
			@Override
			public boolean isFirst() {
				return false;
			}
			
			@Override
			public boolean hasPrevious() {
				return false;
			}
			
			@Override
			public boolean hasNext() {
				return false;
			}
			
			@Override
			public boolean hasContent() {
				return false;
			}
			
			@Override
			public Sort getSort() {
				return null;
			}
			
			@Override
			public int getSize() {
				return 0;
			}
			
			@Override
			public int getNumberOfElements() {
				return 0;
			}
			
			@Override
			public int getNumber() {
				return 0;
			}
			
			@Override
			public List<Gps> getContent() {
				return null;
			}
			
			@Override
			public <S> Page<S> map(Converter<? super Gps, ? extends S> converter) {
				return null;
			}
			
			@Override
			public int getTotalPages() {
				return 0;
			}
			
			@Override
			public long getTotalElements() {
				return 0;
			}
		};
		when(gpsDataService.findAllPaging(anyInt())).thenReturn(page);
		ResponsePaginationDto<LatestGpsDto> result = service.getLatestTrack(1);
		assertEquals(0, result.getTotalPage().intValue());
	}
	
	@Test
	public void testGetLatestTrackOk() {
		Page<Gps> page = new Page<Gps>() {
			
			@Override
			public Iterator<Gps> iterator() {
				return null;
			}
			
			@Override
			public Pageable previousPageable() {
				return null;
			}
			
			@Override
			public Pageable nextPageable() {
				return null;
			}
			
			@Override
			public boolean isLast() {
				return false;
			}
			
			@Override
			public boolean isFirst() {
				return false;
			}
			
			@Override
			public boolean hasPrevious() {
				return false;
			}
			
			@Override
			public boolean hasNext() {
				return false;
			}
			
			@Override
			public boolean hasContent() {
				return false;
			}
			
			@Override
			public Sort getSort() {
				return null;
			}
			
			@Override
			public int getSize() {
				return 0;
			}
			
			@Override
			public int getNumberOfElements() {
				return 0;
			}
			
			@Override
			public int getNumber() {
				return 0;
			}
			
			@Override
			public List<Gps> getContent() {
				Gps gps = new Gps();
				gps.setId(1L);
				gps.setName("a");
				return Arrays.asList(gps);
			}
			
			@Override
			public <S> Page<S> map(Converter<? super Gps, ? extends S> converter) {
				return null;
			}
			
			@Override
			public int getTotalPages() {
				return 1;
			}
			
			@Override
			public long getTotalElements() {
				return 1;
			}
		};
		when(gpsDataService.findAllPaging(anyInt())).thenReturn(page);
		ResponsePaginationDto<LatestGpsDto> result = service.getLatestTrack(1);
		assertEquals("a", result.getData().get(0).getName());
	}
}
