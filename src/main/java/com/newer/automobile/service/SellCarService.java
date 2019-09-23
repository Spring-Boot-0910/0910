package com.newer.automobile.service;

import com.newer.automobile.domain.SellCar;
import com.newer.automobile.mapper.SellCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellCarService {
    @Autowired
    private  SellCarMapper sellCarMapper;

   public SellCar add(SellCar sellCar){
       return sellCarMapper.add();
   }
}
