package com.newer.automobile.controller;

import com.newer.automobile.domain.Province;
import com.newer.automobile.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    //省级
    @RequestMapping("province")
    public ResponseEntity<?> provinces() {
        return new ResponseEntity<>(siteService.provinces(), HttpStatus.OK);
    }

    //市级
    @RequestMapping("city")
    public ResponseEntity<?> city(@RequestParam("PROVINCE_CODE") String PROVINCE_CODE) {
        return new ResponseEntity<>(siteService.city(PROVINCE_CODE), HttpStatus.OK);
    }

    //二级市
    @RequestMapping("area")
    public ResponseEntity<?> area(@RequestParam("CITY_CODE") String CITY_CODE) {
        return new ResponseEntity<>(siteService.areas(CITY_CODE), HttpStatus.OK);
    }

    //街区
    @RequestMapping("street")
    public ResponseEntity<?> street(@RequestParam("AREA_CODE") String AREA_CODE) {
        return new ResponseEntity<>(siteService.streets(AREA_CODE), HttpStatus.OK);
    }
}
