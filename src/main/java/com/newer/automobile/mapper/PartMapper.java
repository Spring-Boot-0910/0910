package com.newer.automobile.mapper;

import com.newer.automobile.domain.Part;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartMapper {

    /**
     * 零件模糊查询/查询
     * @param partType
     * @return
     */
    public List<Part> partByPartType(@Param("partType")String partType);

}
