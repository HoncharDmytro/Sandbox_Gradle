package com.sandbox_gradle.test_01_01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config2 {
    @Bean("textOne")
    public String getTextOne(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Config2, bean textOne(1) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "1111";
    }

    @Bean("textTwo")
    public String getTextTwo(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Config2, bean textTwo(2) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "2222";
    }

    @Bean("textThree")
    public String getTextThree(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Config2, bean textThree(3) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "3333";
    }
}
