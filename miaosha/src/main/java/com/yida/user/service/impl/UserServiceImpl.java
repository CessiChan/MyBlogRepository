package com.yida.user.service.impl;

import com.yida.user.dao.UserInfoDOMapper;
import com.yida.user.dao.UserPasswordDOMapper;
import com.yida.user.dataObject.UserInfoDO;
import com.yida.user.dataObject.UserPasswordDO;
import com.yida.user.service.UserService;
import com.yida.user.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(userInfoDO==null) {
            return null;
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(id);
        return convertFromDataObject(userInfoDO, userPasswordDO);
    }

    private UserModel convertFromDataObject(UserInfoDO userInfoDO, UserPasswordDO userPasswordDO) {
        if (userInfoDO == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userInfoDO, userModel);
        if (userPasswordDO == null) {
            userModel.setEncrptPassWord(userPasswordDO.getEncrptPassword());
        }
        return userModel;
    }
}
