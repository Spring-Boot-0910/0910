package com.newer.automobile.controller;

import com.newer.automobile.domain.SellCar;
import com.newer.automobile.service.SellCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SellCarController {
    @Autowired
    private SellCarService sellCarService;

    @RequestMapping("/partByPartType")
    public ResponseEntity<?> add(@RequestParam("sc1") String sc1,
                                 @RequestParam("sc2") String sc2,
                                 @RequestParam("sc3") String sc3,
                                 @RequestParam("sctime") Date sctime,
                                 @RequestParam("sckm") Double sckm,
                                 @RequestParam("expectedPrice") Double expectedPrice,
                                 @RequestParam("scimg") String scimg,
                                 @RequestParam("province") String province,
                                 @RequestParam("city") String city,
                                 @RequestParam("area") String area,
                                 @RequestParam("street") String street,
                                 @RequestParam("message") String message) {
        SellCar sellCar = new SellCar();
        return new ResponseEntity<>(sellCarService.add(sellCar), HttpStatus.OK);

    }
}
