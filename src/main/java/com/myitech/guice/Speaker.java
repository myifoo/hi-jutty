package com.myitech.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.myitech.guice.services.ActionService;
import com.myitech.guice.services.HelloService;

public class Speaker {
    @Inject
    HelloService helloService; // 成员对象注入
    ActionService action;
    ActionService jump;

    @Inject
    @Named("Name")
    String name;

    @Inject // 构造器注入
    public Speaker(@Named("Action")ActionService action, @Named("Jump")ActionService jump) {
        this.action = action;
        this.jump = jump;
    }


    public void say() {
        System.out.println("I'm "+name);
        helloService.say();
    }

    public void act() {
        action.act();
    }

    public void jump() {
        jump.act();
    }
}
