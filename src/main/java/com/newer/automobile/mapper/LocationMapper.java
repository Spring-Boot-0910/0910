package com.newer.automobile.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

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
    @Insert("insert into location values(null,#{uid},#{name},#{phone},#{province},#{city},#{area},#{street},#{message})")
    public int locationAdd(@Param("uid")Integer uid,@Param("name")String name,
                           @Param("phone")String phone,@Param("province")String province,
                           @Param("city")String city,@Param("area")String area,
                           @Param("street")String street,@Param("message")String message);

}
