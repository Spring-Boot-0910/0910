package com.newer.automobile.mapper;

import com.newer.automobile.domain.Maintain;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MaintainMapper {

    /**
     * 请求服务
     *
     * @param maintain
     * @return
     */
    @Insert("insert into maintain values(null,#{mname},#{ucar},#{phone},#{email},#{Service},#{time},#{by1},null)")
    public int maintainAdd(Maintain maintain);

    //后台

    /**
     * 查询所有未完成服务
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<Maintain> maintainSel(@Param("startIndex") int startIndex,
                                      @Param("pageSize") int pageSize,
                                      @Param("by1")String by1);

    /**
     * 服务总数
     * @param by1
     * @return
     */
    @Select("select count(*) from maintain where by1=#{by1}")
    public int count(@Param("by1")String by1);

    /**
     * 修改服务
     * @return
     */
    @Update("update maintain set by1=#{by1} where mid=#{mid}")
    public int maintainUpd(@Param("by1")String by1,
                                      @Param("mid")Integer mid);

    /**
     * 删除服务
     * @param mid
     * @return
     */
    @Delete("delete from maintain where mid=#{mid}")
    public int maintainDel(@Param("mid")Integer mid);



}
