package com.myitech.guice;

import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.net.InetSocketAddress;

public class WebServer {
    public void start() {
        Server webserver = new Server(new InetSocketAddress("localhost", 8080));
        ServletContextHandler servletContextHandler =
                new ServletContextHandler();

        servletContextHandler.addFilter(GuiceFilter.class, "/api/*", null);
        servletContextHandler.addServlet(DefaultServlet.class, "/api/*");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("webroot");
        resourceHandler.setAliases(true);

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{servletContextHandler, resourceHandler,new DefaultHandler()});
        webserver.setHandler(handlers);

        try {
            webserver.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
