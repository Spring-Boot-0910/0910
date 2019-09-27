package com.newer.automobile.mapper;

import com.newer.automobile.domain.Car;
import com.newer.automobile.domain.Parameter;
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
    @Select("select * from car where crank='新车' order by ctime desc limit 0, 8")
    public List<Car> newestCar();

    /**
     * 查询优惠车辆
     * @return
     */
    @Select("select * from car discount!=0")
    public List<Car> specialCar();

    //遍历所有的车
    public List<Car> queryCar(@Param("crank")String crank,@Param("startIndex")Integer startIndex,@Param("pageSize") Integer pageSize,@Param("cname")String cname,@Param("ctype") String ctype,
                              @Param("colour")String colour,@Param("transmission")String transmission,@Param("fueltype")String fueltype,
                              @Param("startYear")String startYear,@Param("endYear")String endYear,@Param("minPrice")String minPrice,@Param("maxPrice")String maxPrice);

    //获取总汽车数
    public int getCount(@Param("crank")String crank,@Param("cname")String cname,@Param("ctype") String ctype,
                        @Param("colour")String colour,@Param("transmission")String transmission,@Param("fueltype")String fueltype,
                        @Param("startYear")String startYear,@Param("endYear")String endYear,@Param("minPrice")String minPrice,@Param("maxPrice")String maxPrice);


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
    @Select("select * from car where bid=#{bid} and ctype=#{ctype}")
    public List<Car> allprice(@Param("bid") Integer bid,@Param("ctype") String ctype);

    //根据carId查询信息
    @Select("select * from car where cid = #{cid}")
    public List<Car> queryCarById(@Param("cid")Integer cid);

    //根据cid查询parameter
    @Select("select * from parameter where cid = #{cid}")
    public List<Parameter> queryParameter(@Param("cid")Integer cid);
}
