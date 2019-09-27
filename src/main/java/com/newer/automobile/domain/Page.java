package com.newer.automobile.domain;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

    private List<T> data;
    private int iTotalDisplayRecords;
    private int iTotalRecords;

    public Page(List<T> data, int iTotalDisplayRecords, int iTotalRecords) {
        this.data = data;
        this.iTotalDisplayRecords = iTotalDisplayRecords;
        this.iTotalRecords = iTotalRecords;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }
}
