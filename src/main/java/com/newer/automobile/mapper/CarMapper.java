package com.newer.automobile.mapper;

import com.newer.automobile.domain.Car;
import org.apache.ibatis.annotations.*;
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
    public List<Car> queryCar(@Param("startIndex")Integer startIndex,@Param("cname")String cname,@Param("ctype") String ctype,
                              @Param("colour")String colour,@Param("transmission")String transmission,@Param("fueltype")String fueltype,
                              @Param("startYear")String startYear,@Param("endYear")String endYear,@Param("minPrice")String minPrice,@Param("maxPrice")String maxPrice);

    //获取总汽车数
    public int getCount(@Param("cname")String cname,@Param("ctype") String ctype,
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

    //后台

    /**
     * 分页查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<Car> carSel(@Param("startIndex") int startIndex,
                            @Param("pageSize") int pageSize);

    /**
     * 总数
     * @return
     */
    @Select("select count(*) from car")
    public int count();

    /**
     * 添加汽车
     * @param car
     * @return
     */
    @Insert("insert into car values(null,#{cname},#{cimg},#{cimg2},#{ctype},#{cprice},#{discount},#{mileage}," +
            "#{ctime},#{colour},#{crank},#{speed},#{pailiang},#{transmission},#{fueltype},#{fuelEconomy},#{bid},null,null)")
    public int carAdd(Car car);

    /**
     * 删除汽车
     * @param cid
     * @return
     */
    @Delete("delete from car where cid=#{cid}")
    public int carDel(@Param("cid")Integer cid);

    /**
     * 修改汽车
     * @param car
     * @return
     */
    @Update("update car set cname=#{cname},cimg=#{cimg},cimg2=#{cimg2},ctype=#{ctype},cprice=#{cprice},discount=#{discount}," +
            "mileage=#{mileage},ctime=#{ctime},colour=#{colour},crank=#{crank},speed=#{speed},pailiang=#{pailiang}," +
            "transmission=#{transmission},fueltype=#{fueltype},fuelEconomy=#{fuelEconomy},bid=#{bid} where cid=#{cid}")
    public int carUpd(Car car);

}
