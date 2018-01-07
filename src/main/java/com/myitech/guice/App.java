package com.myitech.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.myitech.guice.modules.AppServletModule;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Injector injector = Guice.createInjector(new AppServletModule());

        injector.getInstance(WebServer.class).start();
    }
}
