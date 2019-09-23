package com.newer.automobile.service;

import com.newer.automobile.domain.Brand;
import com.newer.automobile.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有logo图案
     *
     * @return
     */
    public List<Brand> queryBrand() {
        return brandMapper.queryBrands();
    }
}
