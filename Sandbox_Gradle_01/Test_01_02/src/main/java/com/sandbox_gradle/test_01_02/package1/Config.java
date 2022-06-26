package com.sandbox_gradle.test_01_02.package1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config {
    @Bean
    public String string1(){
        return "String1 from Config1";
    }

    @Bean
    public String string2(){
        return "String2 from Config2";
    }

    @Bean
    public String string3(){
        return "String3 from Config3";
    }

    @Bean
    public String string4(){
        return "String4 from Config4";
    }
}
