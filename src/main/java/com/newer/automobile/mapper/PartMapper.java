package com.newer.automobile.mapper;

import com.newer.automobile.domain.Part;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PartMapper {

    /**
     * 查询
     * @return
     */
    public List<Part> partByPartType();

    /**
     * 根据零件类型查询
     * @param partType
     * @return
     */
    @Select("select * from part where partType=#{partType}")
    public List<Part> partByType(@Param("partType")String partType);

    /**
     * 根据id查询
     * @return
     */
    @Select("select * from part where pid=#{pid}")
    public Part partById(@Param("pid")Integer pid);

}
