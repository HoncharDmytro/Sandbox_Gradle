package com.sandbox_gradle.test_01_02.package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service//("component1") - "component1" - it's ID of this bean, u can skip it, just @Service, id will be same
public class Component {
    private String string1;
    private String string2;
    private String string3;
    private String string4;

    public String getString1() {
        return string1;
    }

    @Autowired
    //@Qualifier("string1")// search bean with ID "string1", if method name is same - have no sense!
    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    @Autowired
    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString3() {
        return string3;
    }

    @Autowired
    public void setString3(String string3) {
        this.string3 = string3;
    }

    public String getString4() {
        return string4;
    }

    @Autowired
    public void setString4(String string4) {
        this.string4 = string4;
    }
}
