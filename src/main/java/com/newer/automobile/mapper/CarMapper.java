package com.newer.automobile.mapper;

import com.newer.automobile.domain.Car;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 根据车的品牌查询所有车型
     * @param bid
     * @return
     */
    @Select("select * from car where bid=#{bid} group by ctype")
    public List<Car> allmodel(@Param("bid") Integer bid);

    /**
     * 根据品牌和车型查询价格
     * @param bid
     * @param ctype
     * @return
     */
    @Select("select * from car where bid=#{bid} and ctype='#{ctype}'")
    public List<Car> allprice(@Param("bid") Integer bid,@Param("ctype") String ctype);
}
