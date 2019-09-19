package com.newer.automobile.controller;

import com.newer.automobile.domain.Maintain;
import com.newer.automobile.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MaintainController {

    @Autowired
    private MaintainService maintainService;

    /**
     * 请求服务
     * @return
     */
    @RequestMapping("/maintainAdd")
    public ResponseEntity<?> maintainAdd(@RequestParam("mname")String mname,@RequestParam("ucar")String ucar,
                                         @RequestParam("phone")String phone,@RequestParam("email")String email,
                                         @RequestParam("Service")String Service,@RequestParam("time")String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date times = null;
        if (time!=null){
            try{
                times = sdf.parse(time);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
        Maintain maintain = new Maintain();
        maintain.setMname(mname);
        maintain.setUcar(ucar);
        maintain.setPhone(phone);
        maintain.setEmail(email);
        maintain.setService(Service);
        maintain.setTime(times);
        System.out.println("ss:"+mname+",p:"+phone);
        int fluRows = maintainService.maintainAdd(maintain);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

}
