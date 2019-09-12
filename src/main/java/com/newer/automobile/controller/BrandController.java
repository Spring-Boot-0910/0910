package com.newer.automobile.controller;

import com.newer.automobile.domain.Brand;
import com.newer.automobile.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/queryBrand")
    public List<Brand> queryBrand(){
        return brandService.queryBrand();
    }
}
