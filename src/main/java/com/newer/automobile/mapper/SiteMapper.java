package com.newer.automobile.mapper;

import com.newer.automobile.domain.Area;
import com.newer.automobile.domain.City;
import com.newer.automobile.domain.Province;
import com.newer.automobile.domain.Street;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 城市三级联动
 */

public interface SiteMapper {

    //省级
    @Select("select PROVINCE_NAME,PROVINCE_CODE from bs_province")
    public List<Province> province();

    //市级
    @Select("select CITY_NAME,CITY_CODE from bs_city where PROVINCE_CODE=#{PROVINCE_CODE}")
    public List<City> city(@Param("PROVINCE_CODE")String PROVINCE_CODE);

    //二级市
    @Select("select AREA_NAME,AREA_CODE from bs_area where CITY_CODE=#{CITY_CODE}")
    public List<Area> areas(@Param("CITY_CODE")String CITY_CODE);

    //街区
    @Select("select STREET_NAME from bs_street where AREA_CODE=#{AREA_CODE}")
    public List<Street> street(@Param("AREA_CODE")String AREA_CODE);

}
