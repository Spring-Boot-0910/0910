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

    /**
     * 根据车的品牌查询所有车型
     * @param bid
     * @return
     */
    public List<Car> allmodel(Integer bid){
        return carMapper.allmodel(bid);
    }

    public List<Car> allprice(Integer bid,String ctype){
        return carMapper.allprice(bid, ctype);
    }
}
