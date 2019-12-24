package com.pay_assign.kpay_jihyun.domain.model;



public class TwoT {

    private String year;
    private String name;
    private String acctNo;

    public TwoT(){};

    public TwoT(String year, String name, String acctNo){
        this.year = year;
        this.acctNo = acctNo;
        this.name = name;
    };


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }
}
