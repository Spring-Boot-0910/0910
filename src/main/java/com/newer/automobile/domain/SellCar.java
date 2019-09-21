package com.newer.automobile.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SellCar {
    private int scid;
    private String sc1;//车牌
    private String sc2;//车系
    private String sc3;//车型
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sctime;//上牌时间
    private Double sckm;//里程
    private Double expectedPrice;//预期价格
    private String scimg;//汽车图片
    private String province;
    private String city;
    private String area;
    private String street;
    private String message;

    public SellCar() {
    }

    public SellCar(int scid, String sc1, String sc2, String sc3, Date sctime, Double sckm, Double expectedPrice, String scimg, String province, String city, String area, String street, String message) {
        this.scid = scid;
        this.sc1 = sc1;
        this.sc2 = sc2;
        this.sc3 = sc3;
        this.sctime = sctime;
        this.sckm = sckm;
        this.expectedPrice = expectedPrice;
        this.scimg = scimg;
        this.province = province;
        this.city = city;
        this.area = area;
        this.street = street;
        this.message = message;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public String getSc1() {
        return sc1;
    }

    public void setSc1(String sc1) {
        this.sc1 = sc1;
    }

    public String getSc2() {
        return sc2;
    }

    public void setSc2(String sc2) {
        this.sc2 = sc2;
    }

    public String getSc3() {
        return sc3;
    }

    public void setSc3(String sc3) {
        this.sc3 = sc3;
    }

    public Date getSctime() {
        return sctime;
    }

    public void setSctime(Date sctime) {
        this.sctime = sctime;
    }

    public Double getSckm() {
        return sckm;
    }

    public void setSckm(Double sckm) {
        this.sckm = sckm;
    }

    public Double getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(Double expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public String getScimg() {
        return scimg;
    }

    public void setScimg(String scimg) {
        this.scimg = scimg;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
