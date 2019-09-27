package com.newer.automobile.mapper;

import com.newer.automobile.domain.Location;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LocationMapper {

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
    @Insert("insert into location values(null,#{uid},#{name},#{phone},#{province},#{city},#{area},#{street},#{message},#{state})")
    public int locationAdd(@Param("uid")Integer uid,@Param("name")String name,
                           @Param("phone")String phone,@Param("province")String province,
                           @Param("city")String city,@Param("area")String area,
                           @Param("street")String street,@Param("message")String message,
                           @Param("state")String state);

    //后台

    /**
     * 分页查询
     * @return
     */
    public List<Location> locationSel(@Param("startIndex") int startIndex,
                                      @Param("pageSize") int pageSize,
                                      @Param("state")String state);

    /**
     *所有地址
     * @param state
     * @return
     */
    @Select("select count(*) from location where state=#{state}")
    public int count(@Param("state")String state);

    /**
     * 修改地址是否送到
     * @return
     */
    @Update("update location set state=#{state} where lid=#{lid}")
    public int locationUpd(@Param("state")String state,
                           @Param("lid")Integer lid);

    /**
     * 删除地址
     * @param lid
     * @return
     */
    @Delete("delete from location where lid=#{lid}")
    public int locationDel(@Param("lid")Integer lid);

}
