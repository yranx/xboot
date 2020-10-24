package com.ranx.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ranx
 * @create 2020-01-13 21:26
 **/
@Order(value = 1) //定义Runner执行顺序
@Component
public class Runner01 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Runner01");
    }
}
