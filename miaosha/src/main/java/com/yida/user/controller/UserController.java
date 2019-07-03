package com.yida.user.controller;

import com.alibaba.druid.util.StringUtils;
import com.yida.user.controller.viewObject.UserVO;
import com.yida.user.service.UserService;
import com.yida.user.service.model.UserModel;
import com.yida.utils.base.BaseController;
import com.yida.utils.base.Md5;
import com.yida.utils.em.EmRegisterMode;
import com.yida.utils.error.BusinessException;
import com.yida.utils.error.EmBusinessError;
import com.yida.utils.response.CommonReturnType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author si_chan
 * @date 2019-06-26
 **/
@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")  //跨域，加上了Access-Control-Allow_Origin
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    //Spring自动注入为当前线程
    @Autowired
    private HttpServletRequest httpServletRequest;

    //用户注册接口
    @RequestMapping(value = "/userLogin", method = {RequestMethod.POST}, consumes = {CONTETN_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType userLogin(@RequestParam(name = "loginNum") String loginNum,
                                      @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (StringUtils.isEmpty(loginNum) || StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "账号密码不能为空");
        }
        //用户登录服务，校验用户登录是否合法
        Md5 md5 = new Md5();
        UserModel userModel = userService.validateLogin(loginNum, md5.EncoderByMd5(password));
        //将登陆凭证加入到session中
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN", true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userModel);
        return CommonReturnType.create("Login sucess");
    }

    //用户注册接口
    @RequestMapping(value = "/userRegisterByPhone", method = {RequestMethod.POST}, consumes = {CONTETN_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType userRegisterByPhone(@RequestParam(name = "account") String account,
                                                @RequestParam(name = "name") String name,
                                                @RequestParam(name = "gender") String gender,
                                                @RequestParam(name = "telphone") String telphone,
                                                @RequestParam(name = "otpCode") String otpCode,
                                                @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //1.验证手机号和对应的OTP码符合
        String sessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telphone);
        if (!StringUtils.equals(otpCode, sessionOtpCode)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不对");
        }
        if (userService.isAccountExist(account)) {         //账号存在
            throw new BusinessException(EmBusinessError.ACCOUNT_ALREADY_EXIST, "账号已被注册");
        }
        if (userService.isPhoneExist(telphone)) {         //手机号
            throw new BusinessException(EmBusinessError.PHONE_ALREADY_EXIST, "手机号已被注册");
        }
        //2.用户注册流程
        UserModel userModel = new UserModel();
        userModel.setAccount(account);
        userModel.setName(name);
        userModel.setGender(gender);
        userModel.setTelphone(telphone);
        //通过手机号注册的
        userModel.setRegisterMode(EmRegisterMode.PHONE.getCode());
        //MD5加密密码
        Md5 md5 = new Md5();
        userModel.setEncrptPassWord(md5.EncoderByMd5(password));
        userService.userRegister(userModel);
        return CommonReturnType.create("Register sucess!");

    }


    //用户获取otp短信接口
    @RequestMapping(value = "/getOtp", method = {RequestMethod.POST}, consumes = {CONTETN_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telphone") String telphone) {
        CommonReturnType commonReturnType = new CommonReturnType();
        //需要按照一定的规则生成OTP
        Random random = new Random();
        int randomNum = random.nextInt(99999);
        if (randomNum < 10000) {
            randomNum += 10000;//为了防止前面全部是0
        }
        String otpCode = String.valueOf(randomNum);
        //将OTP与对应手机号关联,此处最好用redis，先用HTTP session绑定
        httpServletRequest.getSession().setAttribute(telphone, otpCode);
        //将验证码发给用户，TODO
        System.out.println("--------------OTP------------" + otpCode);
        commonReturnType.setStatus("success");
        commonReturnType.setData("Send ok!");
        return commonReturnType;
    }


    @RequestMapping("/getUser")
    @ResponseBody
    public CommonReturnType getUserById(String id) throws BusinessException {
        UserModel userModel = userService.getUserById(id);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }


}
