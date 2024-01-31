package com.dunshan.cloud.config;

import com.dunshan.cloud.SpringHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 拦截器
 * @author: 李文
 * @create: 2024-01-31 14:56
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public SpringHandlerInterceptor interceptor() {
        return new SpringHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor())
                //拦截所有请求
                .addPathPatterns("/**");
    }
}

