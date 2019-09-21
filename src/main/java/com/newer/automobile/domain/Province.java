package com.newer.automobile.domain;

import java.util.Date;

public class Province {
    private int PROVINCE_ID;
    private String PROVINCE_CODE;
    private String PROVINCE_NAME;
    private String SHORT_NAME;
    private String LNG;
    private String LAT;
    private int SORT;
    private Date GMT_CREATE;
    private Date GMT_MODIFIED;
    private String MEMO;
    private int DATA_STATE;
    private String TENANT_CODE;

    public Province() {
    }

    public Province(int PROVINCE_ID, String PROVINCE_CODE, String PROVINCE_NAME, String SHORT_NAME, String LNG, String LAT, int SORT, Date GMT_CREATE, Date GMT_MODIFIED, String MEMO, int DATA_STATE, String TENANT_CODE) {
        this.PROVINCE_ID = PROVINCE_ID;
        this.PROVINCE_CODE = PROVINCE_CODE;
        this.PROVINCE_NAME = PROVINCE_NAME;
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

    public int getPROVINCE_ID() {
        return PROVINCE_ID;
    }

    public void setPROVINCE_ID(int PROVINCE_ID) {
        this.PROVINCE_ID = PROVINCE_ID;
    }

    public String getPROVINCE_CODE() {
        return PROVINCE_CODE;
    }

    public void setPROVINCE_CODE(String PROVINCE_CODE) {
        this.PROVINCE_CODE = PROVINCE_CODE;
    }

    public String getPROVINCE_NAME() {
        return PROVINCE_NAME;
    }

    public void setPROVINCE_NAME(String PROVINCE_NAME) {
        this.PROVINCE_NAME = PROVINCE_NAME;
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
