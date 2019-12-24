package com.pay_assign.kpay_jihyun.domain.model;

public class BrThreeFourTForQuery {

    private String brName;
    private String brCod;
    private Long sumAmt;


    public BrThreeFourTForQuery(String brName, String brCod, Long sumAmt){
        this.brName = brName;
        this.brCod = brCod;
        this.sumAmt = sumAmt;
    };

    public String getBrName() {
        return brName;
    }

    public void setBrName(String brName) {
        this.brName = brName;
    }

    public String getBrCod() {
        return brCod;
    }

    public void setBrCod(String brCod) {
        this.brCod = brCod;
    }

    public Long getSumAmt() {
        return sumAmt;
    }

    public void setSumAmt(Long sumAmt) {
        this.sumAmt = sumAmt;
    }
}
