package com.newer.automobile.controller;

import com.newer.automobile.domain.ShoppingCart;
import com.newer.automobile.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车
     * @param shname
     * @param shimg
     * @param unitPrice
     * @param quantity
     * @return
     */
    @RequestMapping("shopCarAdd")
    public ResponseEntity<?> shopCarAdd(@RequestParam("shname")String shname, @RequestParam("shimg")String shimg,
                                        @RequestParam("unitPrice")String unitPrice, @RequestParam("quantity")String quantity){
        double price = 0;
        int quantitys = 0;
        if (unitPrice!=null){
            price = Double.parseDouble(unitPrice);
        }
        if (quantity!=null){
            quantitys = Integer.parseInt(quantity);
        }
        int fluRows = shoppingCartService.shopCarAdd(shname,shimg,price,quantitys);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 删除商品
     * @param shid
     * @return
     */
    @RequestMapping("shopCarDel")
    public ResponseEntity<?> shopCarDel(@RequestParam("shid")String shid){
        Integer id = 0;
        if (shid!=null){
            id = Integer.parseInt(shid);
        }
        int fluRows = shoppingCartService.shopCarDel(id);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

    /**
     * 查询所有商品
     * @return
     */
    @RequestMapping("shopCarAll")
    public ResponseEntity<?> shopCarAll(){
        List<ShoppingCart> list = shoppingCartService.shopCarAll();
        if (list==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    /**
     * 修改商品数量
     * @return
     */
    @RequestMapping("shopCarUpd")
    public ResponseEntity<?> shopCarUpd(@RequestParam("shid")String shid,
                                        @RequestParam("quantity")String quantity){
        Integer id = 0;
        int quantitys = 0;
        if (shid!=null){
            id = Integer.parseInt(shid);
        }
        if (quantity!=null){
            quantitys = Integer.parseInt(quantity);
        }
        int fluRows = shoppingCartService.shopCarUpd(quantitys,id);
        if (fluRows==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }

}
