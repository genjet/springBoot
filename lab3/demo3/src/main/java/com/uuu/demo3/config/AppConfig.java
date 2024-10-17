package com.uuu.demo3.config;

import com.uuu.demo3.calc.AddCalculator;
import com.uuu.demo3.calc.Calculator;
import com.uuu.demo3.calc.SubCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean(name = "add")
    public Calculator cal1() {
        return new AddCalculator();
    }

    @Bean(name = "sub")
    public Calculator cal2() {
        return new SubCalculator();
    }
}
