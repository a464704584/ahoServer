package com.cy.ahoServer.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.cy.ahoServer.base.BaseResponse;
import com.google.gson.Gson;

/**
 * @创建者 CY
 * @创建时间 2019/12/30 13:21
 * @描述
 */
public class LoginInterceptor implements HandlerInterceptor {
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	if (handler instanceof HandlerMethod) {
    		HandlerMethod hMethod=(HandlerMethod)handler;	
    		Interceptor annotation=hMethod.getBean().getClass().getAnnotation(Interceptor.class);
    		if (annotation !=null) {
    			if (!annotation.value()) {
           			returnResponse(response);
			    	return false;
				}
    			annotation=hMethod.getMethod().getAnnotation(Interceptor.class);
       			if (annotation !=null&&!annotation.value()) {
       				returnResponse(response);
			    	return false;
       			}
       			
    		}else {
    			annotation=hMethod.getMethod().getAnnotation(Interceptor.class);
       			if (annotation !=null&&!annotation.value()) {
       				returnResponse(response);
			    	return false;
       			}
			}
		}
    	return true;
    }

    private void returnResponse(HttpServletResponse response){
        PrintWriter writer=null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            BaseResponse<String> baseResponse=new BaseResponse<>();
            baseResponse.error("token信息错误");
            baseResponse.setBody("");
            baseResponse.setCode(-1000);
            Gson gson=new Gson();
            writer.print(gson.toJson(baseResponse));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
