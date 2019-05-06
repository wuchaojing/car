package com.car.demo.config;

import com.car.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InteceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/safe_problem/total_audit");//我先暂时放行，方便及时测试
        super.addInterceptors(registry);
    }

}
