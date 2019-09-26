package com.newer.automobile.service;

import com.newer.automobile.domain.Location;
import com.newer.automobile.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                           String street,String message,String state){
        return locationMapper.locationAdd(uid, name,phone, province, city, area, street, message,state);
    }

    //后台

    /**
     * 查询地址
     * @param startIndex
     * @param pageSize
     * @param state
     * @return
     */
    public List<Location> locationSel(int startIndex, int pageSize, String state){
        return locationMapper.locationSel(startIndex, pageSize, state);
    }

    /**
     * 所有地址
     * @param state
     * @return
     */
    public int count( String state){
        return locationMapper.count(state);
    }

    /**
     * 修改地址是否送到
     * @return
     */
    public int locationUpd(String state,Integer lid){
        return locationMapper.locationUpd(state,lid);
    }

    /**
     * 删除地址
     * @param lid
     * @return
     */
    public int locationDel(Integer lid){
        return locationMapper.locationDel(lid);
    }

}
