package com.newer.automobile.service;

import com.newer.automobile.domain.Car;
import com.newer.automobile.domain.Parameter;
import com.newer.automobile.mapper.CarMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
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

    //查询所有车
    public List<Car> queryCar(Integer bid,String crank,Integer startIndex,Integer pageSize,String cname,String ctype,String colour,String transmission,String fueltype,String startYear,String endYear,String minPrice,String maxPrice){
        return carMapper.queryCar(bid,crank,startIndex, pageSize,cname, ctype, colour, transmission, fueltype, startYear, endYear, minPrice, maxPrice);
    }

    //获取所有汽车数量
    public int getCount(String crank,String cname,String ctype,String colour,String transmission,String fueltype,String startYear,String endYear,String minPrice,String maxPrice){
        return carMapper.getCount(crank,cname, ctype, colour, transmission, fueltype, startYear, endYear, minPrice, maxPrice);
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

    //后台

    /**
     * 分页查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<Car> carSel(int startIndex, int pageSize){
        return carMapper.carSel(startIndex, pageSize);
    }

    /**
     * 所有零件数量
     * @return
     */
    public int count(){
        return carMapper.count();
    }

    /**
     * 添加零件
     * @param car
     * @return
     */
    public int carAdd(Car car){
        return carMapper.carAdd(car);
    }

    /**
     * 删除零件
     * @param cid
     * @return
     */
    public int carDel(Integer cid){
        return carMapper.carDel(cid);
    }

    /**
     * 修改零件
     * @param car
     * @return
     */
    public int carUpd(Car car){
        return carMapper.carUpd(car);
    }


    public List<Parameter> queryParameter(Integer cid){
        return carMapper.queryParameter(cid);
    }

    public List<Car> queryCarById(Integer cid){
        return carMapper.queryCarById(cid);
    }

    public Integer queryByParameter(String ctype,String cprice,Integer brand){
        return carMapper.queryByParameter(ctype,cprice,brand);
    }
}
