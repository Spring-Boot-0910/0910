package com.newer.automobile.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TestDrive implements Serializable {
    private static final long serialVersionUID = -5741577698873729293L;
    private Integer tid;
    private Integer cid;
    private Integer uid;
    private String tname;
    private String tphone;
    private String temail;
//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
//    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone = "GMT+8")
    private String ttime;
    private String cname;
    private String ctype;
    private String uname;

    public TestDrive() {
    }

    public TestDrive(Integer tid, Integer cid, Integer uid, String tname, String tphone, String temail, String ttime, String cname, String ctype, String uname) {
        this.tid = tid;
        this.cid = cid;
        this.uid = uid;
        this.tname = tname;
        this.tphone = tphone;
        this.temail = temail;
        this.ttime = ttime;
        this.cname = cname;
        this.ctype = ctype;
        this.uname = uname;
    }

    public TestDrive(Integer cid, Integer uid, String tname, String tphone, String temail, String ttime) {
        this.cid = cid;
        this.uid = uid;
        this.tname = tname;
        this.tphone = tphone;
        this.temail = temail;
        this.ttime = ttime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    @Override
    public String toString() {
        return "TestDrive{" +
                "tid=" + tid +
                ", cid=" + cid +
                ", uid=" + uid +
                ", tname='" + tname + '\'' +
                ", tphone='" + tphone + '\'' +
                ", temail='" + temail + '\'' +
                ", ttime=" + ttime +
                '}';
    }
}


