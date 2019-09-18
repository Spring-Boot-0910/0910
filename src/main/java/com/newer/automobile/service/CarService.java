package com.newer.automobile.service;

import com.newer.automobile.domain.Car;
import com.newer.automobile.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarMapper carMapper;

    /**
     * 查询最新8条的记录
     * @return
     */
    public List<Car> newestCar(){
        return carMapper.newestCar();
    }

    /**
     * 查询优惠车
     * @return
     */
    public List<Car> specialCar(){
        return carMapper.specialCar();
    }
}