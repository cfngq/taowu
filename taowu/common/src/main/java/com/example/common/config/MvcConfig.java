package com.example.common.config;

import com.example.common.interceptor.UserInfoInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnClass(DispatcherServlet.class)
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInfoInterceptor())
                .addPathPatterns("/cart/**")
                .addPathPatterns("/user/me","/user/deduct")
                .addPathPatterns("/address/**")
                .addPathPatterns("/order/**")
                .addPathPatterns("/pay-order/**")
                .addPathPatterns("/item/**")
                .order(1);
    }
}
