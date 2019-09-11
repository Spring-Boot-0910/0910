package com.newer.automobile.security.domain;

import java.io.Serializable;

public class JwtAuthenticationResquest implements Serializable {

    private String username;
    private String password;

    public JwtAuthenticationResquest() {
    }

    public JwtAuthenticationResquest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JwtAuthenticationResquest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
