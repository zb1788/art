package com.boz.config;

import com.boz.controller.interceptor.LoginInterceptor;
import com.boz.controller.interceptor.OneInterceptor;
import com.boz.controller.interceptor.UploadInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private OneInterceptor oneInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private UploadInterceptor uploadInterceptor;


    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }


    /**
     * 对某个控制器单独拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(oneInterceptor).addPathPatterns("/one/**");
        super.addInterceptors(registry);

        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/user/findUserByUsernameAndPwd","/register");
        super.addInterceptors(registry);
    }



}
