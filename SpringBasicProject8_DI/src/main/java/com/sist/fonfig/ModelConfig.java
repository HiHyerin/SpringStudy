package com.sist.fonfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sist.model")
// <context:component-scan base-package="com.sist.model"/>
public class ModelConfig {

}
