package com.itheima.dao;

import com.itheima.domain.City;

import java.util.List;

public interface CityDao {
    List<City> findAll()throws Exception;
}
