package com.sandbox_gradle.test_01_01;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class LazyConfig {
//CLASS(COMPONENT) AND BEANS MUST BE MARKED @LAZY,
// BOTH OF THEM, ONLY THEN THEY WILL BE CALLED ONLY IN CLASS TEST3(WHERE WE WORK WITH THEM IMMEDIATELY)
    @Bean("eeny")
    @Lazy
    public String getEeny(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("LazyConfig, bean eeny(1) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "Lazy bean one";
    }

    @Bean("meeny")
    @Lazy
    public String getMeeny(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("LazyConfig, bean meeny(2) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "Lazy bean two";
    }

    @Bean("miny")
    @Lazy
    public String getMiny(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("LazyConfig, bean miny(3) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "Lazy bean three";
    }


    @Bean("burn")
    // NOT LAZY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public String getBurn(){
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("LazyConfig, bean burn(4) initialization!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        return "Lazy bean four";
    }
}
