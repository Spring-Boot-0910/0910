package com.newer.automobile.controller;

import com.newer.automobile.domain.Car;
import com.newer.automobile.domain.Parameter;
import com.newer.automobile.domain.Page;
import com.newer.automobile.service.CarService;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//汽车管理
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
    public List<Car> queryCar(@RequestParam("crank")String crank,@RequestParam("startIndex") Integer startIndex,@RequestParam("pageSize") Integer pageSize, @RequestParam("cname")String cname, @RequestParam("ctype") String ctype,
                              @RequestParam("colour")String colour, @RequestParam("transmission")String transmission, @RequestParam("fueltype")String fueltype,
                              @RequestParam("startYear")String startYear, @RequestParam("endYear")String endYear, @RequestParam("minPrice")String minPrice, @RequestParam("maxPrice")String maxPrice){
        return carService.queryCar(crank,startIndex,pageSize, cname, ctype, colour, transmission, fueltype, startYear, endYear, minPrice, maxPrice);
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

    //后台
    /**
     * 查询汽车
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/carSel")
    public ResponseEntity<?> carSel(HttpServletRequest request) throws IOException {
        String startIndex = request.getParameter("iDisplayStart");
        String pageSize = request.getParameter("iDisplayLength");
        int startIn = 0;
        int pageSizeIn = 0;
        if(startIndex!=null) {
            startIn = Integer.parseInt(startIndex);
        }
        if(pageSize!=null) {
            pageSizeIn=Integer.parseInt(pageSize);
        }
        List<Car> list = carService.carSel(startIn,pageSizeIn);
        int count = carService.count();
        return new ResponseEntity<>(new Page<Car>(list,count,count),HttpStatus.OK);
    }

    /**
     * 添加汽车
     * @return
     */
    @PostMapping("/carAdd")
    public ResponseEntity<?> carAdd(@RequestParam("cname")String cname,@RequestParam("cimg")String cimg,
                                     @RequestParam("cimg2")String cimg2,@RequestParam("ctype")String ctype,
                                     @RequestParam("cprice")String cprice,@RequestParam("discount")String discount,
                                     @RequestParam("mileage")String mileage,@RequestParam("ctime")String ctime,
                                     @RequestParam("colour")String colour,@RequestParam("crank")String crank,
                                     @RequestParam("speed")String speed,@RequestParam("pailiang")String pailiang,
                                     @RequestParam("transmission")String transmission,@RequestParam("fueltype")String fueltype,
                                     @RequestParam("fuelEconomy")String fuelEconomy,@RequestParam("bid")String bid){
        double cprices = 0;
        double mileages = 0;
        double speeds = 0;
        double pailiangs = 0;
        int bids = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ctimes = null;
        if (ctime!=null){
            try{
                ctimes = sdf.parse(ctime);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
        if (cprice!=null){
            cprices = Double.parseDouble(cprice);
        }
        if (mileage!=null){
            mileages = Double.parseDouble(mileage);
        }
        if (speed!=null){
            speeds = Double.parseDouble(speed);
        }
        if (pailiang!=null){
            pailiangs = Double.parseDouble(pailiang);
        }
        if (bid!=null){
            bids = Integer.parseInt(bid);
        }
        Car car = new Car();
        car.setCname(cname);
        car.setCimg(cimg);
        car.setCimg2(cimg2);
        car.setCtype(ctype);
        car.setCprice(cprices);
        car.setDiscount(discount);
        car.setMileage(mileages);
        car.setCtime(ctimes);
        car.setColour(colour);
        car.setCrank(crank);
        car.setSpeed(speeds);
        car.setPailiang(pailiangs);
        car.setTransmission(transmission);
        car.setFueltype(fueltype);
        car.setFuelEconomy(fuelEconomy);
        car.setBid(bids);
        int fluRows = carService.carAdd(car);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 修改汽车
     * @return
     */
    @RequestMapping("/carUpd")
    public ResponseEntity<?> carUpd(@RequestParam("cname")String cname,@RequestParam("cimg")String cimg,
                                     @RequestParam("cimg2")String cimg2,@RequestParam("ctype")String ctype,
                                     @RequestParam("cprice")String cprice,@RequestParam("discount")String discount,
                                     @RequestParam("mileage")String mileage,@RequestParam("ctime")String ctime,
                                     @RequestParam("colour")String colour,@RequestParam("crank")String crank,
                                     @RequestParam("speed")String speed,@RequestParam("pailiang")String pailiang,
                                     @RequestParam("transmission")String transmission,@RequestParam("fueltype")String fueltype,
                                     @RequestParam("fuelEconomy")String fuelEconomy,@RequestParam("bid")String bid,
                                     @RequestParam("cid")String cid){
        int id = 0;
        double cprices = 0;
        double mileages = 0;
        double speeds = 0;
        double pailiangs = 0;
        int bids = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date ctimes = null;
        if (ctime!=null){
            try{
                ctimes = sdf.parse(ctime);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
        if (cprice!=null){
            cprices = Double.parseDouble(cprice);
        }
        if (mileage!=null){
            mileages = Double.parseDouble(mileage);
        }
        if (speed!=null){
            speeds = Double.parseDouble(speed);
        }
        if (pailiang!=null){
            pailiangs = Double.parseDouble(pailiang);
        }
        if (bid!=null){
            bids = Integer.parseInt(bid);
        }
        if (cid!=null){
            id = Integer.parseInt(cid);
        }
        Car car = new Car();
        car.setCname(cname);
        car.setCimg(cimg);
        car.setCimg2(cimg2);
        car.setCtype(ctype);
        car.setCprice(cprices);
        car.setDiscount(discount);
        car.setMileage(mileages);
        car.setCtime(ctimes);
        car.setColour(colour);
        car.setCrank(crank);
        car.setSpeed(speeds);
        car.setPailiang(pailiangs);
        car.setTransmission(transmission);
        car.setFueltype(fueltype);
        car.setFuelEconomy(fuelEconomy);
        car.setBid(bids);
        car.setCid(id);
        int fluRows = carService.carUpd(car);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 删除汽车
     * @param cid
     * @return
     */
    @RequestMapping("/carDel")
    public ResponseEntity<?> carDel(@RequestParam("cid")String cid){
        int id = 0;
        if (cid!=null){
            id = Integer.parseInt(cid);
        }
        int fluRows = carService.carDel(id);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 批量删除
     * @return
     */
    @RequestMapping("/carDels")
    public ResponseEntity<?> carDels(HttpServletRequest request){
        String ary = request.getParameter("ary");

        JSONArray ja = (JSONArray)JSONSerializer.toJSON(ary);
        JsonConfig jc = new JsonConfig();
        jc.setArrayMode(JsonConfig.MODE_OBJECT_ARRAY);
        jc.setRootClass(String.class);
        String a[] = (String[])JSONSerializer.toJava(ja,jc);

        int in[] = new int[a.length];
        for(int i = 0;i<a.length;i++) {
            in[i]=Integer.parseInt(a[i]);
        }
        int fluRows = 0;
        if(in!=null) {
            for(int i : in) {
                fluRows = carService.carDel(i);
            }
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
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
}
