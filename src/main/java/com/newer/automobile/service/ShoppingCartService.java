package com.newer.automobile.service;

import com.newer.automobile.domain.ShoppingCart;
import com.newer.automobile.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 加入购物车
     * @param shname
     * @param shimg
     * @param unitPrice
     * @param quantity
     * @return
     */
    public int shopCarAdd(String shname,String shimg,
                          Double unitPrice,Integer quantity){
        return shoppingCartMapper.shopCarAdd(shname,shimg,unitPrice,quantity);
    }

    /**
     * 删除购物车商品
     * @param shid
     * @return
     */
    public int shopCarDel(Integer shid){
        return shoppingCartMapper.shopCarDel(shid);
    }

    /**
     * 查询所有商品
     * @return
     */
    public List<ShoppingCart> shopCarAll(){
        return shoppingCartMapper.shopCarAll();
    }

    /**
     * 修改购买数量
     * @param shid
     * @param quantity
     * @return
     */
    public int shopCarUpd(Integer shid,int quantity){
        return shoppingCartMapper.shopCarUpd(shid,quantity);
    }

}
