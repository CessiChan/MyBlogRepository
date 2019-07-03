package com.yida.user.controller.viewObject;

/**
 * @author si_chan
 * @date 2019-06-26
 * 返回给前端的信息
 **/
public class UserVO {
    private String account;
    private String name;
    private String gender;//性别，'1代表男性，2代表女性'
    private String telphone;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
