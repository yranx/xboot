package com.ranx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ranx.mapper")
public class BootMybatisAnnotateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisAnnotateApplication.class, args);
	}

}
