package com.newer.automobile.mapper;

import com.newer.automobile.domain.SellCar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SellCarMapper {

    @Insert("insert into sellcar values(null,#{sc1},#{sc2},#{sc3},#{sctime},#{sckm},#{expectedPrice},#{scimg},#{province},#{city},#{area},#{street},#{message})")
    public SellCar add();

    //后台

    /**
     * 分页查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<SellCar> sellCarSel(@Param("startIndex") int startIndex,
                                    @Param("pageSize") int pageSize);

    /**
     * 总数
     * @return
     */
    @Select("select count(*) from sellcar")
    public int count();


}
