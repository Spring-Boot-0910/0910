package com.newer.automobile.domain;

import java.io.Serializable;

public class Email implements Serializable {

    private String sender;
    private String shouJian;
    private String msg;

    public Email() {
    }

    public Email(String sender, String shouJian, String msg) {
        this.sender = sender;
        this.shouJian = shouJian;
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getShouJian() {
        return shouJian;
    }

    public void setShouJian(String shouJian) {
        this.shouJian = shouJian;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Email{" +
                "sender='" + sender + '\'' +
                ", shouJian='" + shouJian + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
