package com.newer.automobile.controller;

import com.newer.automobile.domain.Part;
import com.newer.automobile.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("partByType")
    public ResponseEntity<?> partByType(@RequestParam("partType")String partType){
        List<Part> list = partService.partByType(partType);
        if (list==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
