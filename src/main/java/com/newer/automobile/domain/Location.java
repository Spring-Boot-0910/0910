package com.newer.automobile.domain;

import java.io.Serializable;

public class Location implements Serializable {
    private static final long serialVersionUID = 1690273153996531780L;
    private Integer lid;
    private Integer uid;
    private String name;
    private String phone;
    private String province;
    private String city;
    private String area;
    private String street;
    private String message;
    private String state;
    private Users users;
    private Province provinces;
    private City citys;
    private Area areas;

    public Location() {
    }

    public Location(Integer lid, Integer uid, String name, String phone, String province, String city, String area, String street, String message, String state, Users users, Province provinces, City citys, Area areas) {
        this.lid = lid;
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.city = city;
        this.area = area;
        this.street = street;
        this.message = message;
        this.state = state;
        this.users = users;
        this.provinces = provinces;
        this.citys = citys;
        this.areas = areas;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Province getProvinces() {
        return provinces;
    }

    public void setProvinces(Province provinces) {
        this.provinces = provinces;
    }

    public City getCitys() {
        return citys;
    }

    public void setCitys(City citys) {
        this.citys = citys;
    }

    public Area getAreas() {
        return areas;
    }

    public void setAreas(Area areas) {
        this.areas = areas;
    }
}
