package com.newer.automobile.mapper;

import com.newer.automobile.domain.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    /**
     * 所有logo图案
     *
     * @return
     */
    @Select("select * from brand")
    public List<Brand> queryBrands();
}
