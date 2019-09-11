package com.newer.automobile.domain;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.io.Serializable;

public class Authoritys implements Serializable {

    private Integer aid;
    private AuthorityName aname;

    public Authoritys() {
    }

    public Authoritys(Integer aid, AuthorityName aname) {
        this.aid = aid;
        this.aname = aname;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public AuthorityName getAname() {
        return aname;
    }

    public void setAname(AuthorityName aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Authoritys{" +
                "aid=" + aid +
                ", aname=" + aname +
                '}';
    }
}
