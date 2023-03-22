package com.sist.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.sist.food.entity","com.sist.food.dao","com.sist.food.controller"})
@SpringBootApplication
public class SpringBootJpaTyhmleafProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaTyhmleafProjectApplication.class, args);
	}

}
