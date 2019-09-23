package com.newer.automobile.mapper;

import com.newer.automobile.domain.SellCar;
import org.apache.ibatis.annotations.Insert;

public interface SellCarMapper {

    @Insert("insert into sellcar values(null,#{sc1},#{sc2},#{sc3},#{sctime},#{sckm},#{expectedPrice},#{scimg},#{province},#{city},#{area},#{street},#{message})")
    public SellCar add();


}
