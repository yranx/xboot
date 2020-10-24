package com.ranx.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ranx
 * @create 2020-01-13 21:27
 **/
@Order(value = 2)
@Component
public class Runner02 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Running Runner02");
    }

}
