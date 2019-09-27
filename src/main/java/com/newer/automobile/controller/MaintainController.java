package com.newer.automobile.controller;

import com.newer.automobile.domain.Maintain;
import com.newer.automobile.domain.Page;
import com.newer.automobile.service.MaintainService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
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
        maintain.setBy1("未完成");
        System.out.println("ss:"+mname+",p:"+phone);
        int fluRows = maintainService.maintainAdd(maintain);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    //后台

    /**
     * 查询未完成服务
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/maintainSel")
    public ResponseEntity<?> maintainSel(HttpServletRequest request) throws IOException {
        String startIndex = request.getParameter("iDisplayStart");
        String pageSize = request.getParameter("iDisplayLength");
        String by1 = request.getParameter("by1");
        int startIn = 0;
        int pageSizeIn = 0;
        if(startIndex!=null) {
            startIn = Integer.parseInt(startIndex);
        }
        if(pageSize!=null) {
            pageSizeIn=Integer.parseInt(pageSize);
        }
        List<Maintain> list = maintainService.maintainSel(startIn,pageSizeIn,by1);
        int count = maintainService.count(by1);
        return new ResponseEntity<>(new Page<Maintain>(list,count,count),HttpStatus.OK);
    }

    /**
     * 修改服务
     * @param by1
     * @param mid
     * @return
     */
    @RequestMapping("/maintainUpd")
    public ResponseEntity<?> maintainUpd(@RequestParam("by1")String by1,@RequestParam("mid")String mid){
        int id = 0;
        if (mid!=null){
            id = Integer.parseInt(mid);
        }
        int fluRows = maintainService.maintainUpd(by1,id);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 删除服务
     * @param mid
     * @return
     */
    @RequestMapping("/maintainDel")
    public ResponseEntity<?> maintainDel(@RequestParam("mid")String mid){
        int id = 0;
        if (mid!=null){
            id = Integer.parseInt(mid);
        }
        int fluRows = maintainService.maintainDel(id);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 批量删除
     * @return
     */
    @RequestMapping("/maintainDels")
    public ResponseEntity<?> maintainDels(HttpServletRequest request){
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
                fluRows = maintainService.maintainDel(i);
            }
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

}
