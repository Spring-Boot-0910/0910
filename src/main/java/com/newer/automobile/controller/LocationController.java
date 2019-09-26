package com.newer.automobile.controller;

import com.newer.automobile.domain.Location;
import com.newer.automobile.domain.Page;
import com.newer.automobile.service.LocationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

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
        String state = "未送达";
        int fluRows = locationService.locationAdd(id, name, phone, province, city, area, street, message,state);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    //后台

    /**
     * 查询地址
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/locationSel")
    public ResponseEntity<?> locationSel(HttpServletRequest request) throws IOException {
        String startIndex = request.getParameter("iDisplayStart");
        String pageSize = request.getParameter("iDisplayLength");
        String state = request.getParameter("state");
        int startIn = 0;
        int pageSizeIn = 0;
        if(startIndex!=null) {
            startIn = Integer.parseInt(startIndex);
        }
        if(pageSize!=null) {
            pageSizeIn=Integer.parseInt(pageSize);
        }
        List<Location> list = locationService.locationSel(startIn,pageSizeIn,state);
        int count = locationService.count(state);
        return new ResponseEntity<>(new Page<Location>(list,count,count),HttpStatus.OK);
    }

    /**
     * 修改地址
     * @return
     */
    @RequestMapping("/locationUpd")
    public ResponseEntity<?> locationUpd(@RequestParam("state")String state,@RequestParam("lid")String lid){
        int id = 0;
        if (lid!=null){
            id = Integer.parseInt(lid);
        }
        int fluRows = locationService.locationUpd(state,id);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 删除地址
     * @param lid
     * @return
     */
    @RequestMapping("/locationDel")
    public ResponseEntity<?> locationDel(@RequestParam("lid")String lid){
        int id = 0;
        if (lid!=null){
            id = Integer.parseInt(lid);
        }
        int fluRows = locationService.locationDel(id);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 批量删除
     * @return
     */
    @RequestMapping("/locationDels")
    public ResponseEntity<?> locationDels(HttpServletRequest request){
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
                fluRows = locationService.locationDel(i);
            }
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

}
