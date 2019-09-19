package com.newer.automobile.mapper;

import com.newer.automobile.domain.Car;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarMapper {
    /**
     * 查询最新8条的记录
     * @return
     */
    @Select("select * from car order by ctime desc limit 0, 8")
    public List<Car> newestCar();

    /**
     * 查询优惠车辆
     * @return
     */
    @Select("select * from car discount!=0")
    public List<Car> specialCar();
}
