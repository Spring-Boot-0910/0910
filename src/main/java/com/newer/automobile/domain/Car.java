package com.newer.automobile.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    private static final long serialVersionUID = -4326473074179232050L;
    private Integer cid;
    private String cname;
    private String cimg;
    private String cimg2;
    private String ctype;
    private Double cprice;
    private String discount;
    private double mileage;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ctime;
    private String colour;
    private String crank;
    private Double speed;
    private Double pailiang;
    private String transmission;
    private String fueltype;
    private String fuelEconomy;
    private Integer bid;
    private String by1;
    private Integer by2;
    private Brand brand;

    public Car() {
    }

    public Car(Integer cid, String cname, String cimg, String cimg2, String ctype, Double cprice, String discount, double mileage, Date ctime, String colour, String crank, Double speed, Double pailiang, String transmission, String fueltype, String fuelEconomy, Integer bid, String by1, Integer by2, Brand brand) {
        this.cid = cid;
        this.cname = cname;
        this.cimg = cimg;
        this.cimg2 = cimg2;
        this.ctype = ctype;
        this.cprice = cprice;
        this.discount = discount;
        this.mileage = mileage;
        this.ctime = ctime;
        this.colour = colour;
        this.crank = crank;
        this.speed = speed;
        this.pailiang = pailiang;
        this.transmission = transmission;
        this.fueltype = fueltype;
        this.fuelEconomy = fuelEconomy;
        this.bid = bid;
        this.by1 = by1;
        this.by2 = by2;
        this.brand = brand;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCimg() {
        return cimg;
    }

    public void setCimg(String cimg) {
        this.cimg = cimg;
    }

    public String getCimg2() {
        return cimg2;
    }

    public void setCimg2(String cimg2) {
        this.cimg2 = cimg2;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public Double getCprice() {
        return cprice;
    }

    public void setCprice(Double cprice) {
        this.cprice = cprice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getCrank() {
        return crank;
    }

    public void setCrank(String crank) {
        this.crank = crank;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getPailiang() {
        return pailiang;
    }

    public void setPailiang(Double pailiang) {
        this.pailiang = pailiang;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(String fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public Integer getBy2() {
        return by2;
    }

    public void setBy2(Integer by2) {
        this.by2 = by2;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
