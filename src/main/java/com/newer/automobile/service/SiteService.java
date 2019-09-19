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

    public List<City> city(@Param("PROVINCE_CODE")String PROVINCE_CODE) {
        return siteMapper.city();
    }

    public List<Street> streets(@Param("CITY_CODE")String CITY_CODE) {
        return siteMapper.street();
    }

    public List<Area> areas(@Param("AREA_CODE") String AREA_CODE) {
        return siteMapper.area();
    }
}
