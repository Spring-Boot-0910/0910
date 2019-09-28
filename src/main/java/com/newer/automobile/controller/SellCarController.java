package com.newer.automobile.controller;

import com.newer.automobile.domain.Page;
import com.newer.automobile.domain.SellCar;
import com.newer.automobile.service.SellCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

//卖车
@RestController
public class SellCarController {
    @Autowired
    private SellCarService sellCarService;

    @RequestMapping("/sellcar")
    public ResponseEntity<?> add(SellCar sellCar) {
        return new ResponseEntity<>(sellCarService.add(sellCar), HttpStatus.OK);
    }

    //后台
    /**
     * 分页查询
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/sellCarSel")
    public ResponseEntity<?> sellCarSel(HttpServletRequest request) throws IOException {
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
        List<SellCar> list = sellCarService.sellCarSel(startIn,pageSizeIn);
        int count = sellCarService.count();
        return new ResponseEntity<>(new Page<SellCar>(list,count,count),HttpStatus.OK);
    }

}
