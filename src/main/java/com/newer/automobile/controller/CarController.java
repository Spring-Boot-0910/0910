package com.newer.automobile.controller;

import com.newer.automobile.domain.Car;
import com.newer.automobile.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询8条最新车
     * @return
     */
    @PostMapping("/newestCar")
    public List<Car> newestCar(){
        return carService.newestCar();
    }

    /**
     * 查询优惠车
     * @return
     */
    @PostMapping("/specialCar")
    public List<Car> specialCar(){
        return carService.specialCar();
    }

    /**
     * 根据品牌查询车辆型号
     * @param bid
     * @return
     */
    @PostMapping("/allmodel")
    public List<Car> allmodel(@RequestParam("bid") Integer bid){
        return carService.allmodel(bid);
    }

    /**
     * 根据品牌和车型查询价格
     * @param bid
     * @param ctype
     * @return
     */
    @PostMapping("/allprice")
    public List<Car> allprice(@RequestParam("bid") Integer bid,@RequestParam("ctype") String ctype){
        return carService.allprice(bid, ctype);
    }
}
