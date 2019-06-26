package com.yida.user.controller;

import com.yida.user.service.UserService;
import com.yida.user.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author si_chan
 * @date 2019-06-26
 **/
@Controller("user")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public UserModel getUserById(String id) {
        return userService.getUserById(id);
    }
}
