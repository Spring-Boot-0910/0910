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
     * 零件模糊查询/查询
     * @param partType
     * @return
     */
    public List<Part> partByPartType(String partType){
        return partMapper.partByPartType(partType);
    }

}
