package com.newer.automobile.domain;

import java.io.Serializable;

public class Part implements Serializable {
    private static final long serialVersionUID = -7184132662483326352L;
    private Integer pid;
    private String pname;
    private String picture;
    private Double pprice;
    private String partType;
    private String describes;
    private String by1;
    private int by2;

    public Part() {
    }

    public Part(Integer pid, String pname, String picture, Double pprice, String partType, String describes, String by1, int by2) {
        this.pid = pid;
        this.pname = pname;
        this.picture = picture;
        this.pprice = pprice;
        this.partType = partType;
        this.describes = describes;
        this.by1 = by1;
        this.by2 = by2;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public int getBy2() {
        return by2;
    }

    public void setBy2(int by2) {
        this.by2 = by2;
    }
}
