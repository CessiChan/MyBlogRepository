package com.yida.utils.checkCode;

public class checkCodeController {

    @ApiOperation(value = "获取图片验证码",notes = "返回ResultDataDto", response = ResultDataDto.class)
    @PostMapping(path = "/getPictureCode",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultDataDto getPictureCode(HttpServletRequest request){
        String param = "ImgVerificationCodeMark";
        String base64ImgStr = sysUserService.createPicVerificationCode(param,request);
        if (StringUtils.isNotBlank(base64ImgStr) && !base64ImgStr.equals(CREATE_VERIFICATION_CODE_ERROR)){
            return ResultDataDto.addOperationSuccess().setData(base64ImgStr);
        }else {
            return ResultDataDto.addOperationFailure(base64ImgStr);
        }
    }
}
