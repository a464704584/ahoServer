package com.cy.ahoServer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @创建者 CY
 * @创建时间 2019/12/27 15:34
 * @描述 虚拟路径配置
 */
@Configuration
public class APPConfig extends WebMvcConfigurationSupport {


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(mapDir+"/**")
//                .addResourceLocations("file:"+dir+"/");
    	registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    	registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");

        //虚拟路径映射
        super.addResourceHandlers(registry);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration=registry.addInterceptor(new LoginInterceptor());
        //拦截所有路径
//        registration.excludePathPatterns("/test/**","/user/login","/user/get");

        super.addInterceptors(registry);
    }
}
