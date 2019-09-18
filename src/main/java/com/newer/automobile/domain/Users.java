package com.newer.automobile.domain;

import java.io.Serializable;
import java.util.List;

public class Users  implements Serializable{
    private Integer uid;
    private String uname;
    private String uemail;
    private String upwd;
    private String uphone;
    private Integer state;
    private Integer type;
    private String by1;
    private Integer by2;
    private List<Authoritys> authoritysList;

    public Users() {
    }

    public Users(Integer uid, String uname, String uemail, String upwd, String uphone, Integer state, Integer type, String by1, Integer by2, List<Authoritys> authoritysList) {
        this.uid = uid;
        this.uname = uname;
        this.uemail = uemail;
        this.upwd = upwd;
        this.uphone = uphone;
        this.state = state;
        this.type = type;
        this.by1 = by1;
        this.by2 = by2;
        this.authoritysList = authoritysList;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public List<Authoritys> getAuthoritysList() {
        return authoritysList;
    }

    public void setAuthoritysList(List<Authoritys> authoritysList) {
        this.authoritysList = authoritysList;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uemail='" + uemail + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uphone='" + uphone + '\'' +
                ", state=" + state +
                ", by1='" + by1 + '\'' +
                ", by2=" + by2 +
                '}';
    }
}
