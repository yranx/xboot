package com.ranx.config;


import com.ranx.controller.interceptor.OneInterceptor;
import com.ranx.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ranx
 * @create 2018-04-22 23:59
 **/
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器按照顺序执行
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
                .addPathPatterns("/one/**"); //被两个拦截器拦截

        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**"); //拦截路径/one/**

        super.addInterceptors(registry);
    }
}
