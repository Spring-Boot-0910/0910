package com.newer.automobile.domain;
import java.io.Serializable;

public class Parameter implements Serializable {

    private Integer pid;
    private String pandt;
    private String fuelEconome;
    private String acceLerationTime;
    private String maximuMspeed;
    private String Trunkolumve;
    private String lwh;
    private String ABS;
    private String BAG;
    private String CPA;
    private String ESPDSC;
    private Integer seating;
    private Integer cid;

    public Parameter() {
    }

    public Parameter(Integer pid, String pandt, String fuelEconome, String acceLerationTime, String maximuMspeed, String trunkolumve, String lwh, String ABS, String BAG, String CPA, String ESPDSC, Integer seating, Integer cid) {
        this.pid = pid;
        this.pandt = pandt;
        this.fuelEconome = fuelEconome;
        this.acceLerationTime = acceLerationTime;
        this.maximuMspeed = maximuMspeed;
        Trunkolumve = trunkolumve;
        this.lwh = lwh;
        this.ABS = ABS;
        this.BAG = BAG;
        this.CPA = CPA;
        this.ESPDSC = ESPDSC;
        this.seating = seating;
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPandt() {
        return pandt;
    }

    public void setPandt(String pandt) {
        this.pandt = pandt;
    }

    public String getFuelEconome() {
        return fuelEconome;
    }

    public void setFuelEconome(String fuelEconome) {
        this.fuelEconome = fuelEconome;
    }

    public String getAcceLerationTime() {
        return acceLerationTime;
    }

    public void setAcceLerationTime(String acceLerationTime) {
        this.acceLerationTime = acceLerationTime;
    }

    public String getMaximuMspeed() {
        return maximuMspeed;
    }

    public void setMaximuMspeed(String maximuMspeed) {
        this.maximuMspeed = maximuMspeed;
    }

    public String getTrunkolumve() {
        return Trunkolumve;
    }

    public void setTrunkolumve(String trunkolumve) {
        Trunkolumve = trunkolumve;
    }

    public String getLwh() {
        return lwh;
    }

    public void setLwh(String lwh) {
        this.lwh = lwh;
    }

    public String getABS() {
        return ABS;
    }

    public void setABS(String ABS) {
        this.ABS = ABS;
    }

    public String getBAG() {
        return BAG;
    }

    public void setBAG(String BAG) {
        this.BAG = BAG;
    }

    public String getCPA() {
        return CPA;
    }

    public void setCPA(String CPA) {
        this.CPA = CPA;
    }

    public String getESPDSC() {
        return ESPDSC;
    }

    public void setESPDSC(String ESPDSC) {
        this.ESPDSC = ESPDSC;
    }

    public Integer getSeating() {
        return seating;
    }

    public void setSeating(Integer seating) {
        this.seating = seating;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
