package com.yida.utils.response;

/**
 * @author si_chan
 * @date 2019-06-26
 **/
public class CommonReturnType {
    //请求返回结果，success和fail
    private String status;
    //如果为success，则data为jason
    //如果为fail，则为通用错误码格式
    private Object data;

    //定义一个通用的创建方法
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
