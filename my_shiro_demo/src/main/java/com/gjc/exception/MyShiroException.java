package com.gjc.exception;

import com.gjc.constant.ResultData;
import com.gjc.constant.RetCode;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常
 */
@ControllerAdvice
public class MyShiroException {

    private Logger log = LoggerFactory.getLogger(MyShiroException.class);

    /**
     * 处理Shiro权限拦截异常
     * 如果返回JSON数据格式请加上 @ResponseBody注解
     */
    @ResponseBody
//    @ExceptionHandler(value = AuthorizationException.class)
    @ExceptionHandler(value = Exception.class)
    public ResultData defaultErrorHandler(Exception e) {
        ResultData resultData = new ResultData(RetCode.FAIL.getCode(), "");
        if (e instanceof IncorrectCredentialsException) {
            resultData.setMsg("用户不存在或者密码错误");
            return resultData;
        }else if(e instanceof LockedAccountException){
            resultData.setMsg("登录失败，该用户已被冻结");
            return resultData;
        } else if (e instanceof AuthenticationException) {
            resultData.setMsg("该用户不存在");
            return resultData;
        } else if (e instanceof AuthorizationException) {
            resultData.setMsg("用户权限不足");
            return resultData;
        } else {
            log.error(e.getMessage(), e);
            resultData.setMsg("程序异常");
            return resultData;
        }

    }
}

