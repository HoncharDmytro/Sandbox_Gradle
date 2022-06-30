package com.sandbox_gradle.test_01_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(Config2.class);
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Test2, context initialisation ended!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        SimpleInterface simple = ctx.getBean(SimpleInterface.class);
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Test2, SimpleInterface bean gotten!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(simple.getTextOne());
        System.out.println(simple.getTextTwo());
        System.out.println(simple.getTextThree());
}
}
