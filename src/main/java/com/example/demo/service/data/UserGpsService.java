package com.example.demo.service.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserGpsDao;
import com.example.demo.entity.UserGps;

@Service
public class UserGpsService {
	
	@Autowired
	private UserGpsDao userGpsDao;
	
	public void saveUserGps(Long gpsId, Long userId) {
		UserGps userGps = new UserGps();
		userGps.setGpsId(gpsId);
		userGps.setUserId(userId);
		userGpsDao.save(userGps);
	}
}
