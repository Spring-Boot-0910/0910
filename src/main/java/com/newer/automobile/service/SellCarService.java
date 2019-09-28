package com.newer.automobile.service;

import com.newer.automobile.domain.SellCar;
import com.newer.automobile.mapper.SellCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellCarService {
    @Autowired
    private  SellCarMapper sellCarMapper;

   public SellCar add(SellCar sellCar){
       return sellCarMapper.add();
   }

    //后台

    /**
     * 分页查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<SellCar> sellCarSel(int startIndex,int pageSize){
        return sellCarMapper.sellCarSel(startIndex, pageSize);
    }

    /**
     * 总数
     * @return
     */
    public int count(){
        return sellCarMapper.count();
    }
}
