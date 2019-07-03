package com.yida.utils.base;

import com.yida.utils.error.BusinessException;
import com.yida.utils.error.EmBusinessError;
import com.yida.utils.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author si_chan
 * @date 2019-06-27
 **/
public class BaseController {

    public static final String CONTETN_TYPE_FORMED = "application/x-www-form-urlencoded";

    //对于controller层不能吸收的异常，可以定义exceptionHandler，抛出的异常作为参数
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {
        Map<String, Object> responseData = new HashMap<>();     //返回的data
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errCode", businessException.getErrCode());
            responseData.put("errMsg", businessException.getErrMsg());
        } else {
            responseData.put("errCode", EmBusinessError.UNKNOW_ERROR.getErrCode());
            responseData.put("errMsg", EmBusinessError.UNKNOW_ERROR.getErrMsg());
        }

        return CommonReturnType.create(responseData, "fail");
    }
}
