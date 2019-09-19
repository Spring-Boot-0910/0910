package com.newer.automobile.mapper;

import com.newer.automobile.domain.Part;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PartMapper {

    /**
     * 零件模糊查询/查询
     *
     * @param partType
     * @return
     */
    public List<Part> partByPartType(@Param("partType") String partType);

    /**
     * 根据id查询
     * @return
     */
    @Select("select * from part where pid=#{pid}")
    public int partById(@Param("pid")Integer pid);

}
