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

    @RequestMapping("/sellcar")
    public ResponseEntity<?> add(SellCar sellCar) {
        return new ResponseEntity<>(sellCarService.add(sellCar), HttpStatus.OK);

    }
}
