package com.ranx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ranx
 * @create 2020-01-13 21:04
 **/

@Configuration
public class CustomBeanConfig {

    /**
     * 使用public修饰@Bean注解的方法
     * 把 RestTemplate交由Spring容器管理，使用时可以使用@Autowired注解注入
     * 可以方便的对 RestTemplate(Bean)做属性方面的定制工作
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
