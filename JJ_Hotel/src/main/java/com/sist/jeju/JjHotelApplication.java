package com.sist.jeju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.sist.jeju.controller","com.sist.jeju.entity","com.sist.jeju.dao","com.sist.jeju.rest"})
@SpringBootApplication
public class JjHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(JjHotelApplication.class, args);
	}

}
