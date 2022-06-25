package com.sandbox_gradle.test_01_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Test {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Test, context initialisation ended!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        SimpleClass simple = ctx.getBean("simpleClass", SimpleClass.class);
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Test, SimpleClass bean geted!!!");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(simple.getValue());

//        GenericXmlApplicationContext ctx =
//                new GenericXmlApplicationContext("classpath:spring/application-context.xml");

//        SimpleClass simple = ctx.getBean("simpleClass", SimpleClass.class);
//        System.out.println(simple.getValue());
    }
}

