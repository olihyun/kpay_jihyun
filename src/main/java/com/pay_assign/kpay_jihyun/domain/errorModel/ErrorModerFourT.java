package com.pay_assign.kpay_jihyun.domain.errorModel;

public class ErrorModerFourT {

    private String code;
    private String 메세지;


    public ErrorModerFourT(String code, String msg){
        this.code = code;
        this.메세지 = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String get메세지() {
        return 메세지;
    }

    public void set메세지(String 메세지) {
        this.메세지 = 메세지;
    }
}
