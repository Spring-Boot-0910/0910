package com.newer.automobile.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Maintain implements Serializable {
    private static final long serialVersionUID = -1281765813766956965L;
    private Integer mid;
    private String mname;
    private String ucar;
    private String phone;
    private String email;
    private String Service;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    private String by1;
    private Integer by2;

    public Maintain() {
    }

    public Maintain(Integer mid, String mname, String ucar, String phone, String email, String service, Date time, String by1, Integer by2) {
        this.mid = mid;
        this.mname = mname;
        this.ucar = ucar;
        this.phone = phone;
        this.email = email;
        Service = service;
        this.time = time;
        this.by1 = by1;
        this.by2 = by2;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getUcar() {
        return ucar;
    }

    public void setUcar(String ucar) {
        this.ucar = ucar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
}
