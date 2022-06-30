package com.sandbox_gradle.test_01_02.package2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Base base = ctx.getBean(Base.class);
        User user1 = new UserImp("Bob", "Shein", 21, "USA","");
        User user2 = new UserImp("Shon", "Keib", 37, "USA","Something");
        User user3 = new UserImp("Kimb", "Jeis", 29, "Canada","Programming");
        base.add(user1);
        base.add(user2);
        base.add(user3);
        base.getAll().forEach(System.out::println);
    }
}
