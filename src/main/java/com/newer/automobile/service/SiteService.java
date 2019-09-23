package com.newer.automobile.service;

import com.newer.automobile.domain.Area;
import com.newer.automobile.domain.City;
import com.newer.automobile.domain.Province;
import com.newer.automobile.domain.Street;
import com.newer.automobile.mapper.SiteMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {
    @Autowired
    private SiteMapper siteMapper;

    public List<Province> provinces() {
        return siteMapper.province();
    }

    public List<City> city(String PROVINCE_CODE) {
        return siteMapper.city(PROVINCE_CODE);
    }

    public List<Area> areas(String CITY_CODE) {
        return siteMapper.areas(CITY_CODE);
    }

    public List<Street> streets(String AREA_CODE) {
        return siteMapper.street(AREA_CODE);
    }

}
