package com.pay_assign.kpay_jihyun.domain.model;

import java.util.List;

public class ThreeTForJson {

    private String year;
    private List<BrThreeFourTForQuery> dataList;

    public ThreeTForJson(String year, List<BrThreeFourTForQuery> dataList){
        this.year = year;
        this.dataList = dataList;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<BrThreeFourTForQuery> getDataList() {
        return dataList;
    }

    public void setDataList(List<BrThreeFourTForQuery> dataList) {
        this.dataList = dataList;
    }
}
