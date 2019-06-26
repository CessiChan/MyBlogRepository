package com.yida.user.service.model;

/**
 * @author si_chan
 * @date 2019-06-26
 **/
public class UserModel {
    private String id;
    private String name;
    private Integer gender;//性别，'1代表男性，2代表女性'
    private String telphone;
    private String registerMode;//注册方式,1为手机，2为微信，3为支付宝',
    private String thirdPartId; //第三方的id
    private String account;//账号
    private String encrptPassWord;//加密密码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public String getThirdPartId() {
        return thirdPartId;
    }

    public void setThirdPartId(String thirdPartId) {
        this.thirdPartId = thirdPartId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEncrptPassWord() {
        return encrptPassWord;
    }

    public void setEncrptPassWord(String encrptPassWord) {
        this.encrptPassWord = encrptPassWord;
    }
}
