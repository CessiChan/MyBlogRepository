package com.yida.utils.em;

public enum EmRegisterMode {
    PHONE("1"),
    WECHART("2"),
    ALIPAY("3")
    ;
    private String code;
    EmRegisterMode(String code){
        this.code=code;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
