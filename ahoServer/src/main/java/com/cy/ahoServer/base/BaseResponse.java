package com.cy.ahoServer.base;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private int code=200;
    private String msg="成功";
    private T body;

    public BaseResponse success(){
        this.setMsg("成功");
        this.setCode(200);
        return this;
    }

    public BaseResponse success(T body){
        this.setMsg("成功");
        this.setCode(200);
        this.setBody(body);
        return this;
    }

    public BaseResponse error(String msg){
        this.setMsg(msg);
        this.setCode(-1);
        return this;
    }

    public BaseResponse error(){
        this.setMsg("您的设备异常");
        this.setCode(-1);
        return this;
    }
}
