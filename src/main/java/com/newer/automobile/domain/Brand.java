package com.newer.automobile.domain;

import java.io.Serializable;

public class Brand implements Serializable {
    private static final long serialVersionUID = -3333516977148673767L;
    private Integer bid;
    private String bname;
    private String bimg;
    private String by1;
    private Integer by2;

    public Brand() {
    }

    public Brand(Integer bid, String bname, String bimg, String by1, Integer by2) {
        this.bid = bid;
        this.bname = bname;
        this.bimg = bimg;
        this.by1 = by1;
        this.by2 = by2;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
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

    @Override
    public String toString() {
        return "Brand{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bimg='" + bimg + '\'' +
                ", by1='" + by1 + '\'' +
                ", by2=" + by2 +
                '}';
    }
}
