package com.uuu.demo3.config;

import com.uuu.demo3.calc.AddCalculator;
import com.uuu.demo3.calc.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Calculator cal1(){
        return new AddCalculator();
    }
}
