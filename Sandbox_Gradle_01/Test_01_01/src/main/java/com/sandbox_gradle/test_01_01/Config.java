package com.sandbox_gradle.test_01_01;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
//@ComponentScan(basePackages = {"com.package1","com.package2","com.package3"})
//@ComponentScan(basePackageClasses = {Class1.class, Class2.class})
//@ComponentScans({
//        @ComponentScan(basePackages = {"com.package1","com.package2","com.package3"}),
//        @ComponentScan(basePackageClasses = {Class1.class, Class2.class})
//})
public class Config {
    @Bean("aboba")
    public String getAboba(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Config, bean aboba(1) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "ganging up!";
    }

    @Bean("text")
    public String getText(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Config, bean text(2) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "that's good!";
    }

    @Bean("value")
    public String getValue(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Config, bean vlue(3) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "YEP, THAT'S IT!!!!";
    }
}
