package com.ssafy.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HwVueUserApiApplication{
	public static void main(String[] args) {
		SpringApplication.run(HwVueUserApiApplication.class, args);
	}

}
