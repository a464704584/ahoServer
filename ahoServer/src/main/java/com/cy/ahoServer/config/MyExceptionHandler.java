package com.cy.ahoServer.config;

import com.cy.ahoServer.base.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @创建者 CY
 * @创建时间 2019/12/28 11:18
 * @描述
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public BaseResponse<?> exceptionHandler(Exception e){
        e.printStackTrace();
        return new BaseResponse<Object>().error();
    }
}
