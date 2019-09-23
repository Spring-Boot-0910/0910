package com.newer.automobile.controller;

import com.newer.automobile.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping("/locationAdd")
    public ResponseEntity<?> locationAdd(@RequestParam("uid")String uid, @RequestParam("name")String name,
                                         @RequestParam("phone")String phone,@RequestParam("province")String province,
                                         @RequestParam("city")String city, @RequestParam("area")String area,
                                         @RequestParam("street")String street, @RequestParam("message")String message){
        System.out.println("uid:"+uid);
        int id = 0;
        if (uid!=null){
            id = Integer.parseInt(uid);
        }
        int fluRows = locationService.locationAdd(id, name, phone, province, city, area, street, message);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

}
