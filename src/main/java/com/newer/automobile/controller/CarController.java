package com.newer.automobile.controller;

import com.newer.automobile.domain.Car;
import com.newer.automobile.domain.Parameter;
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

    //遍历所有汽车
    @PostMapping("/queryCar")
    public List<Car> queryCar(@RequestParam("bid") Integer bid,@RequestParam("crank")String crank,@RequestParam("startIndex") Integer startIndex,@RequestParam("pageSize") Integer pageSize, @RequestParam("cname")String cname, @RequestParam("ctype") String ctype,
                              @RequestParam("colour")String colour, @RequestParam("transmission")String transmission, @RequestParam("fueltype")String fueltype,
                              @RequestParam("startYear")String startYear, @RequestParam("endYear")String endYear, @RequestParam("minPrice")String minPrice, @RequestParam("maxPrice")String maxPrice){
        return carService.queryCar(bid,crank,startIndex,pageSize, cname, ctype, colour, transmission, fueltype, startYear, endYear, minPrice, maxPrice);
    }

    //获取总汽车数
    @PostMapping("/getCount")
    public int getCount(@RequestParam("crank")String crank, @RequestParam("cname")String cname, @RequestParam("ctype") String ctype,
                         @RequestParam("colour")String colour, @RequestParam("transmission")String transmission, @RequestParam("fueltype")String fueltype,
                         @RequestParam("startYear")String startYear, @RequestParam("endYear")String endYear, @RequestParam("minPrice")String minPrice, @RequestParam("maxPrice")String maxPrice){
        int count = carService.getCount(crank,cname, ctype, colour, transmission, fueltype, startYear, endYear, minPrice, maxPrice);
        System.out.println("count="+count+"crank="+crank);
        return  count;
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

    //根据cid查询car信息
    @PostMapping("/queryCarById")
    public List<Car> queryCarById(@RequestParam("cid")Integer cid){
        List<Car> list = carService.queryCarById(cid);
        return list;
    }

    //根据cid查询parameter信息
    @PostMapping("/queryParameter")
    public List<Parameter> queryParameter(@RequestParam("cid")Integer cid){
        List<Parameter> parameter = carService.queryParameter(cid);
        return parameter;
    }

    @PostMapping("/queryByParameter")
    public Integer queryByParameter(@RequestParam("ctype")String ctype,@RequestParam("cprice")String cprice,@RequestParam("brand") Integer brand){
        System.out.println(cprice+"---"+ctype+"---------"+brand);
        int count =  carService.queryByParameter(ctype,cprice,brand);
        System.out.println("0000000000"+count);
        return count;
    }
}
