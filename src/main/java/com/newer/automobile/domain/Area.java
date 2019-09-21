package com.newer.automobile.domain;

import java.util.Date;

public class Area {
    private int AREA_ID;
    private String AREA_CODE;
    private String CITY_CODE;
    private String AREA_NAME;
    private String SHORT_NAME;
    private String LNG;
    private String LAT;
    private int SORT;
    private Date GMT_CREATE;
    private Date GMT_MODIFIED;
    private String MEMO;
    private int DATA_STATE;
    private String TENANT_CODE;

    public Area() {
    }

    public Area(int AREA_ID, String AREA_CODE, String CITY_CODE, String AREA_NAME, String SHORT_NAME, String LNG, String LAT, int SORT, Date GMT_CREATE, Date GMT_MODIFIED, String MEMO, int DATA_STATE, String TENANT_CODE) {
        this.AREA_ID = AREA_ID;
        this.AREA_CODE = AREA_CODE;
        this.CITY_CODE = CITY_CODE;
        this.AREA_NAME = AREA_NAME;
        this.SHORT_NAME = SHORT_NAME;
        this.LNG = LNG;
        this.LAT = LAT;
        this.SORT = SORT;
        this.GMT_CREATE = GMT_CREATE;
        this.GMT_MODIFIED = GMT_MODIFIED;
        this.MEMO = MEMO;
        this.DATA_STATE = DATA_STATE;
        this.TENANT_CODE = TENANT_CODE;
    }

    public int getAREA_ID() {
        return AREA_ID;
    }

    public void setAREA_ID(int AREA_ID) {
        this.AREA_ID = AREA_ID;
    }

    public String getAREA_CODE() {
        return AREA_CODE;
    }

    public void setAREA_CODE(String AREA_CODE) {
        this.AREA_CODE = AREA_CODE;
    }

    public String getAREA_NAME() {
        return AREA_NAME;
    }

    public void setAREA_NAME(String AREA_NAME) {
        this.AREA_NAME = AREA_NAME;
    }

    public String getCITY_CODE() {
        return CITY_CODE;
    }

    public void setCITY_CODE(String CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    public String getSHORT_NAME() {
        return SHORT_NAME;
    }

    public void setSHORT_NAME(String SHORT_NAME) {
        this.SHORT_NAME = SHORT_NAME;
    }

    public String getLNG() {
        return LNG;
    }

    public void setLNG(String LNG) {
        this.LNG = LNG;
    }

    public String getLAT() {
        return LAT;
    }

    public void setLAT(String LAT) {
        this.LAT = LAT;
    }

    public int getSORT() {
        return SORT;
    }

    public void setSORT(int SORT) {
        this.SORT = SORT;
    }

    public Date getGMT_CREATE() {
        return GMT_CREATE;
    }

    public void setGMT_CREATE(Date GMT_CREATE) {
        this.GMT_CREATE = GMT_CREATE;
    }

    public Date getGMT_MODIFIED() {
        return GMT_MODIFIED;
    }

    public void setGMT_MODIFIED(Date GMT_MODIFIED) {
        this.GMT_MODIFIED = GMT_MODIFIED;
    }

    public String getMEMO() {
        return MEMO;
    }

    public void setMEMO(String MEMO) {
        this.MEMO = MEMO;
    }

    public int getDATA_STATE() {
        return DATA_STATE;
    }

    public void setDATA_STATE(int DATA_STATE) {
        this.DATA_STATE = DATA_STATE;
    }

    public String getTENANT_CODE() {
        return TENANT_CODE;
    }

    public void setTENANT_CODE(String TENANT_CODE) {
        this.TENANT_CODE = TENANT_CODE;
    }
}
