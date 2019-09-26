package com.newer.automobile.service;

import com.newer.automobile.domain.Maintain;
import com.newer.automobile.mapper.MaintainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //后台

    /**
     * 查询所有未完成服务
     * @param startIndex
     * @param pageSize
     * @param by1
     * @return
     */
    public List<Maintain> maintainSel(int startIndex, int pageSize, String by1){
        return maintainMapper.maintainSel(startIndex, pageSize,by1);
    }

    /**
     * 服务数量
     * @param by1
     * @return
     */
    public int count(String by1){
        return maintainMapper.count(by1);
    }


    /**
     * 修改服务
     * @param by1
     * @param mid
     * @return
     */
    public int maintainUpd(String by1,Integer mid){
        return maintainMapper.maintainUpd(by1, mid);
    }

    /**
     * 删除服务
     * @param mid
     * @return
     */
    public int maintainDel(Integer mid){
        return maintainMapper.maintainDel(mid);
    }

}
