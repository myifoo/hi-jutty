package com.myitech.guice.services.impl;

import com.myitech.guice.services.HelloService;

public class HelloServiceImpl implements HelloService{

    public void say() {
        System.out.println("Hello Guice!");
    }
}
