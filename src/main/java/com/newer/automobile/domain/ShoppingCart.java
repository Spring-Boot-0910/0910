package com.newer.automobile.domain;

import java.io.Serializable;

public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 952981648287273684L;
    private Integer shid;
    private String shname;
    private String shimg;
    private Double unitPrice;
    private Integer quantity;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer shid, String shname, String shimg, Double unitPrice, Integer quantity) {
        this.shid = shid;
        this.shname = shname;
        this.shimg = shimg;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Integer getShid() {
        return shid;
    }

    public void setShid(Integer shid) {
        this.shid = shid;
    }

    public String getShname() {
        return shname;
    }

    public void setShname(String shname) {
        this.shname = shname;
    }

    public String getShimg() {
        return shimg;
    }

    public void setShimg(String shimg) {
        this.shimg = shimg;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
