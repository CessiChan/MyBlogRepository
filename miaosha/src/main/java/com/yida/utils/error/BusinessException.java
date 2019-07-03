package com.yida.utils.error;

/**
 * 包装器实现业务异常类，将异常包装了一层
 *
 * @author si_chan
 * @date 2019-06-26
 **/
public class BusinessException extends Exception implements CommonError {
    private CommonError commonError;  //这是一个接口,异常的处理信息通过统一的接口传入

    public BusinessException(CommonError commonError) {
        super();//调用父类构造函数
        this.commonError = commonError;
    }

    public BusinessException(CommonError commonError, String errMsg) {
        super();//调用父类构造函数
        this.commonError = commonError;
        this.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this.commonError;
    }
}
