package com.myitech.guice.modules;

import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceFilter;
import com.myitech.guice.WebServer;
import com.myitech.guice.resources.HelloResource;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class AppServletModule extends JerseyServletModule{

    @Override
    protected void configureServlets() {
        binder().requireExplicitBindings();
        bind(GuiceFilter.class);
        bind(GuiceContainer.class);
        bind(WebServer.class);
        bind(HelloResource.class).in(Scopes.SINGLETON);

        serve("/*").with(GuiceContainer.class);
    }
}
