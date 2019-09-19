package com.newer.automobile.mapper;

import com.newer.automobile.domain.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShoppingCartMapper {

    /**
     * 添加购物车
     * @param shname
     * @param shimg
     * @param unitPrice
     * @param quantity
     * @return
     */
    @Insert("insert into shoppingcart values(null,#{shname},#{shimg},#{unitPrice},#{quantity})")
    public int shopCarAdd(@Param("shname")String shname,@Param("shimg")String shimg,
                          @Param("unitPrice")Double unitPrice,@Param("quantity")Integer quantity);

    /**
     * 删除商品
     * @param shid
     * @return
     */
    @Delete("delete from shoppingcart where shid=#{shid}")
    public int shopCarDel(@Param("shid")Integer shid);

    /**
     * 查询所有商品
     * @return
     */
    @Select("select * from shoppingcart")
    public List<ShoppingCart> shopCarAll();

    /**
     * 修改购买数量
     * @param shid
     * @param quantity
     * @return
     */
    @Update("update shoppingcart set quantity=#{quantity} where shid=#{shid}")
    public int shopCarUpd(@Param("quantity")int quantity,@Param("shid")Integer shid);

}
