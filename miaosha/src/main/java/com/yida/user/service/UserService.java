package com.yida.user.service;

import com.yida.user.service.model.UserModel;
import com.yida.utils.error.BusinessException;

public interface UserService {
    UserModel getUserById(String id);

    boolean isAccountExist(String account);

    boolean isPhoneExist(String telphone);

    void userRegister(UserModel userModel) throws BusinessException;

    UserModel validateLogin(String loginNum, String password) throws BusinessException;
}
