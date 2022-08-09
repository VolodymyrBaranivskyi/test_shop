package com.volodymyrbaranivskyi.test_shop.сonfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.volodymyrbaranivskyi")
public class ApplicationConfig {
}
