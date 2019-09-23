package com.newer.automobile.mapper;

import com.newer.automobile.domain.Car;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.security.core.parameters.P;

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

    //遍历所有的车
    public List<Car> queryCar(@Param("startIndex")Integer startIndex,@Param("cname")String cname,@Param("ctype") String ctype,
                              @Param("colour")String colour,@Param("transmission")String transmission,@Param("fueltype")String fueltype,
                              @Param("startYear")String startYear,@Param("endYear")String endYear,@Param("minPrice")String minPrice,@Param("maxPrice")String maxPrice);

    //获取总汽车数
    public int getCount(@Param("cname")String cname,@Param("ctype") String ctype,
                        @Param("colour")String colour,@Param("transmission")String transmission,@Param("fueltype")String fueltype,
                        @Param("startYear")String startYear,@Param("endYear")String endYear,@Param("minPrice")String minPrice,@Param("maxPrice")String maxPrice);
    
}
