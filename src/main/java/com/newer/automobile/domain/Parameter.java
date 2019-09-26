package com.newer.automobile.domain;

import java.util.List;

public class Parameter {
    private List<?> data;
    private Integer iTotalDisplayRecords;
    private Integer iTotalRecords;

    public Parameter() {
    }

    public Parameter(List<?> data, Integer iTotalDisplayRecords, Integer iTotalRecords) {
        this.data = data;
        this.iTotalDisplayRecords = iTotalDisplayRecords;
        this.iTotalRecords = iTotalRecords;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Integer getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public Integer getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(Integer iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }
}
