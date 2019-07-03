package com.yida.utils.base.validator;

import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


/**
 * 校验工具
 * @author si_chan
 * @date 2019-07-02
 **/
public class ValidateorImpl implements InitializingBean {
    private Validator validator;

    @Override
    public void afterPropertiesSet() throws Exception {
        //通过工厂方式实例化
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    //实现校验方法，并且返回校验结果
    public ValidationResult validate(Object bean) {
        final ValidationResult result = new ValidationResult();
        //入参为需要校验的bean，返回值为set，若违背规则，则返回值为在set内
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size() > 0) {
            //出现错误
            result.setHasErrors(true);
            constraintViolationSet.forEach(constraintViolation -> {
                String errMsg = constraintViolation.getMessage();
                //获取哪个字段发生的错误
                String propertyName = constraintViolation.getPropertyPath().toString();
                result.getErrorMsgMap().put(propertyName, errMsg);
            });
        }
        return result;
    }
}
