package com.yida.user.service.impl;

import com.yida.user.dao.UserInfoDOMapper;
import com.yida.user.dao.UserPasswordDOMapper;
import com.yida.user.dataObject.UserInfoDO;
import com.yida.user.dataObject.UserPasswordDO;
import com.yida.user.service.UserService;
import com.yida.user.service.model.UserModel;
import com.yida.utils.error.BusinessException;
import com.yida.utils.error.EmBusinessError;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author si_chan
 * @date 2019-06-26
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoDOMapper userInfoDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(String id) {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByPrimaryKey(id);
        if (userInfoDO == null) {
            return null;
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(id);
        return convertFromDataObject(userInfoDO, userPasswordDO);
    }

    @Override
    public boolean isAccountExist(String account) {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByAccount(account);
        if (userInfoDO == null || userInfoDO.getId() == null || userInfoDO.getId().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isPhoneExist(String telphone) {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByTelphone(telphone);
        if (userInfoDO == null || userInfoDO.getId() == null || userInfoDO.getId().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private UserModel convertFromDataObject(UserInfoDO userInfoDO, UserPasswordDO userPasswordDO) {
        if (userInfoDO == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userInfoDO, userModel);
        if (userPasswordDO != null) {
            userModel.setEncrptPassWord(userPasswordDO.getEncrptPassword());
        }
        return userModel;
    }

    @Override
    @Transactional
    public void userRegister(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        if (StringUtils.isEmpty(userModel.getAccount())
                || StringUtils.isEmpty(userModel.getName())
                || userModel.getGender() == null
                || StringUtils.isEmpty(userModel.getTelphone())) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        userModel.setId(uuid);      //随机生成uuid作为id
        UserInfoDO userInfoDO = convertFromModel(userModel);
        try {
            userInfoDOMapper.insertSelective(userInfoDO);
            UserPasswordDO userPasswordDO = convertPasswordFromModel(userModel, uuid);
            userPasswordDOMapper.insertSelective(userPasswordDO);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "重复注册");
        }
        return;
    }

    public UserInfoDO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(userModel, userInfoDO);
        return userInfoDO;
    }

    public UserPasswordDO convertPasswordFromModel(UserModel userModel, String userId) {
        if (userModel == null) {
            return null;
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getEncrptPassWord());
        userPasswordDO.setUserId(userId);
        userPasswordDO.setId(uuid);
        return userPasswordDO;
    }

    //用户登录是否合法
    public UserModel validateLogin(String loginNum, String password) throws BusinessException {
        UserModel userModel = this.getUserByPhoneOrAccount(loginNum);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.LOGIN_IN_FAILED);
        }
        //比对密码
        if (!StringUtils.equals(password, userModel.getEncrptPassWord())) {
            throw new BusinessException(EmBusinessError.LOGIN_IN_FAILED);
        }
        return userModel;
    }

    public UserModel getUserByPhoneOrAccount(String loginNum) {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByLoginNum(loginNum);
        if (userInfoDO == null || userInfoDO.getId() == null || userInfoDO.getId().equals("")) {
            return null;
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userInfoDO.getId());
        return convertFromDataObject(userInfoDO, userPasswordDO);
    }
}


