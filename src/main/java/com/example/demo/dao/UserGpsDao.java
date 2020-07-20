package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserGps;

@Repository
public interface UserGpsDao extends CrudRepository<UserGps, Long> {

}
