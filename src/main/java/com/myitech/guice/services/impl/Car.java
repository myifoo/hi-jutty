package com.myitech.guice.services.impl;

import com.myitech.guice.services.Vehicle;

public class Car implements Vehicle {
    public void run() {
        System.out.println("Run a car!");
    }
}
