package com.newer.automobile.controller;

import com.newer.automobile.domain.Page;
import com.newer.automobile.domain.Part;
import com.newer.automobile.service.PartService;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class PartController {

    @Autowired
    private PartService partService;

    /**
     * 查询
     * @return
     */
    @RequestMapping("/partByPartType")
    public ResponseEntity<?> partByPartType(){
        List<Part> list = partService.partByPartType();
        if (list==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    /**
     * 根据id查询
     * @param pid
     * @return
     */
    @RequestMapping("partById")
    public ResponseEntity<?> partById(@RequestParam("pid")String pid){
        Integer id = 0;
        if (pid!=null){
            id = Integer.parseInt(pid);
        }
        Part part = partService.partById(id);
        if (part==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(part,HttpStatus.OK);
    }

    /**
     * 查询相同类型的数据
     * @param partType
     * @return
     */
    @RequestMapping("partByType")
    public ResponseEntity<?> partByType(@RequestParam("partType")String partType){
        List<Part> list = partService.partByType(partType);
        if (list==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //后台

    /**
     * 查询零件
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/partSel")
    public ResponseEntity<?> partSel(HttpServletRequest request) throws IOException {
        String startIndex = request.getParameter("iDisplayStart");
        String pageSize = request.getParameter("iDisplayLength");
        String partType = request.getParameter("partType");
        int startIn = 0;
        int pageSizeIn = 0;
        if(startIndex!=null) {
            startIn = Integer.parseInt(startIndex);
        }
        if(pageSize!=null) {
            pageSizeIn=Integer.parseInt(pageSize);
        }
        List<Part> list = partService.partSel(startIn,pageSizeIn,partType);
        int count = partService.count(partType);
        return new ResponseEntity<>(new Page<Part>(list,count,count),HttpStatus.OK);
    }

    /**
     * 添加零件
     * @param pname
     * @param picture
     * @param pprice
     * @param partType
     * @param describes
     * @return
     */
    @PostMapping("/partAdd")
    public ResponseEntity<?> partAdd(@RequestParam("pname")String pname,@RequestParam("picture")String picture,
                                     @RequestParam("pprice")String pprice,@RequestParam("partType")String partType,
                                     @RequestParam("describes")String describes){
        double price = 0;
        if (pprice!=null){
            price = Double.parseDouble(pprice);
        }
        Part part = new Part();
        part.setPname(pname);
        part.setPicture(picture);
        part.setPprice(price);
        part.setPartType(partType);
        part.setDescribes(describes);
        int fluRows = partService.partAdd(part);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 修改零件
     * @return
     */
    @RequestMapping("/partUpd")
    public ResponseEntity<?> partUpd(@RequestParam("pname")String pname,@RequestParam("picture")String picture,
                                         @RequestParam("pprice")String pprice,@RequestParam("partType")String partType,
                                         @RequestParam("describes")String describes,@RequestParam("pid")String pid){
        int id = 0;
        double price = 0;
        if (pid!=null){
            id = Integer.parseInt(pid);
        }
        if (pprice!=null){
            price = Double.parseDouble(pprice);
        }
        Part part = new Part();
        part.setPname(pname);
        part.setPicture(picture);
        part.setPprice(price);
        part.setPartType(partType);
        part.setDescribes(describes);
        part.setPid(id);
        int fluRows = partService.partUpd(part);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 删除零件
     * @param pid
     * @return
     */
    @RequestMapping("/partDel")
    public ResponseEntity<?> partDel(@RequestParam("pid")String pid){
        int id = 0;
        if (pid!=null){
            id = Integer.parseInt(pid);
        }
        int fluRows = partService.partDel(id);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 批量删除
     * @return
     */
    @RequestMapping("/partDels")
    public ResponseEntity<?> partDels(HttpServletRequest request){
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
                fluRows = partService.partDel(i);
            }
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

}
