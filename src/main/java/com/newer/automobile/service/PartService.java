package com.newer.automobile.service;

import com.newer.automobile.domain.Part;
import com.newer.automobile.mapper.PartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {

    @Autowired
    private PartMapper partMapper;

    /**
     * 查询
     * @return
     */
    public List<Part> partByPartType(){
        return partMapper.partByPartType();
    }

    /**
     * 根据id查询
     * @param pid
     * @return
     */
    public Part partById(Integer pid){
        return partMapper.partById(pid);
    }

    public List<Part> partByType(String partType){
        return partMapper.partByType(partType);
    }

}
