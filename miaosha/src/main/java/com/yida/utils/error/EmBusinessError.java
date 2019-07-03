package com.yida.utils.error;

public enum EmBusinessError implements CommonError {
    //通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    UNKNOW_ERROR(10002, "未知错误"),
    //20000开头为用户信息相关错误
    USER_NOT_EXIST(20001, "用户不存在"),

    ACCOUNT_ALREADY_EXIST(20002, "账号已存在"),

    PHONE_ALREADY_EXIST(20003, "手机号已存在"),

    ACCOUNT_NOT_EXIST(20004, "账号不存在"),

    PHONE_NOT_EXIST(20005, "手机号不存在"),

    LOGIN_IN_FAILED(20006, "账号或密码错误");

    EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
