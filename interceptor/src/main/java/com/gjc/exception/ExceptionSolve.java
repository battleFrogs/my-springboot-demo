package com.gjc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ExceptionSolve {

    /**
     * -------- 通用异常处理方法 --------
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public void error(Exception e) {

    }

    /**
     * -------- 指定异常处理方法 --------
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public void error(NullPointerException e) {

    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public void error(IndexOutOfBoundsException e) {
    }

    /**-------- 自定义定异常处理方法 --------**/
    @ExceptionHandler(CMSException.class)
    @ResponseBody
    public void error(CMSException e) {
    }


}
