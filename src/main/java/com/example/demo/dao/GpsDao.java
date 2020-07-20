package com.example.demo.dao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Gps;

@Repository
public interface GpsDao extends PagingAndSortingRepository<Gps, Long> {
	
}
