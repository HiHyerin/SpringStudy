package com.sist.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.sist.food.controller","com.sist.food.service","com.sist.food.mapper"})
@SpringBootApplication
public class SpringBootDatabaseProjectApplication {

   public static void main(String[] args) {
      SpringApplication.run(SpringBootDatabaseProjectApplication.class, args);
   }

}