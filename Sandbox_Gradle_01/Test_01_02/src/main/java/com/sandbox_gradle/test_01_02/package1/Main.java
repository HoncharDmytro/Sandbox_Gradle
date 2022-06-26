package com.sandbox_gradle.test_01_02.package1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Component comp = ctx.getBean(Component.class);
        System.out.println(
                "Strings: \n"
                + comp.getString1() + "\n"
                + comp.getString2() + "\n"
                + comp.getString3() + "\n"
                + comp.getString4()
        );
    }
}
