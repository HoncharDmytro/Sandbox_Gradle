package com.sandbox_gradle.test_01_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(LazyConfig.class);
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Test3, context initialisation ended!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        LazyClass simple = ctx.getBean(LazyClass.class);
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Test3, LazyClass bean gotten!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(simple.getMiny());
        System.out.println(simple.getBurn());
    }
}
