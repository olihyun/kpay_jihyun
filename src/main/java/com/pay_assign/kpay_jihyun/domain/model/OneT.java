package com.pay_assign.kpay_jihyun.domain.model;

public class OneT {

    private String year;
    private String name;
    private String acctNo;
    private long sumAmt;

    public OneT(){

    }

    public OneT(String year, String name, String acctNo, long sumAmt){
        this.acctNo = acctNo;
        this.year = year;
        this.name = name;
        this.sumAmt = sumAmt;
    }


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

    public long getSumAmt() {
        return sumAmt;
    }

    public void setSumAmt(long sumAmt) {
        this.sumAmt = sumAmt;
    }
}
