package com.myitech.guice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceFilter;
import com.myitech.guice.services.ActionService;
import com.myitech.guice.services.HelloService;
import com.myitech.guice.services.impl.HelloServiceImpl;
import com.myitech.guice.services.impl.JumpActionServiceImpl;
import com.myitech.guice.services.impl.WalkActionServiceImpl;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.eclipse.jetty.servlet.DefaultServlet;

import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;

public class AppModule extends AbstractModule {
    protected void configure() {
        bind(HelloService.class).to(HelloServiceImpl.class);
        bind(ActionService.class).annotatedWith(Names.named("Action")).to(WalkActionServiceImpl.class);
        bind(ActionService.class).annotatedWith(Names.named("Jump")).to(JumpActionServiceImpl.class);
        bind(String.class).annotatedWith(Names.named("Name")).toInstance("Anteng");
    }
}
