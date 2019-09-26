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

    /**
     * 查询相同类型的数据
     * @param partType
     * @return
     */
    public List<Part> partByType(String partType){
        return partMapper.partByType(partType);
    }

    //后台

    /**
     * 分页查询
     * @param startIndex
     * @param pageSize
     * @param partType
     * @return
     */
    public List<Part> partSel(int startIndex, int pageSize, String partType){
        return partMapper.partSel(startIndex, pageSize, partType);
    }

    /**
     * 所有零件数量
     * @param partType
     * @return
     */
    public int count(String partType){
        return partMapper.count(partType);
    }

    /**
     * 添加零件
     * @param part
     * @return
     */
    public int partAdd(Part part){
        return partMapper.partAdd(part);
    }

    /**
     * 删除零件
     * @param pid
     * @return
     */
    public int partDel(Integer pid){
        return partMapper.partDel(pid);
    }

    /**
     * 修改零件
     * @param part
     * @return
     */
    public int partUpd(Part part){
        return partMapper.partUpd(part);
    }

}
