package com.newer.automobile.service;

import com.newer.automobile.domain.Maintain;
import com.newer.automobile.mapper.MaintainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class MaintainService {

    @Autowired
    private MaintainMapper maintainMapper;

    /**
     * 请求服务
     *
     * @param maintain
     * @return
     */
    public int maintainAdd(Maintain maintain) {
        return maintainMapper.maintainAdd(maintain);
    }

}
