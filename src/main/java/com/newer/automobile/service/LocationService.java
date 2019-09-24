package com.newer.automobile.service;

import com.newer.automobile.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationMapper locationMapper;

    /**
     * 添加地址
     * @param uid
     * @param province
     * @param city
     * @param area
     * @param street
     * @param message
     * @return
     */
    public int locationAdd(Integer uid,String name,String phone,String province,String city,String area,
                           String street,String message){
        return locationMapper.locationAdd(uid, name,phone, province, city, area, street, message);
    }

}
