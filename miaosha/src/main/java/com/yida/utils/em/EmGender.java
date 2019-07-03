package com.yida.utils.em;

/**
 * @author si_chan
 * @date 2019-06-28
 **/
public enum EmGender {
    MALE("1"),

    FAMLE("2");

    private String code;

    EmGender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }}
