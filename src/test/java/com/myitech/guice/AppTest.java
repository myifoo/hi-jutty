package com.myitech.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.myitech.guice.modules.AppModule;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        say();
    }


    public void say() {
        Injector injector = Guice.createInjector(new AppModule());
        Speaker s = injector.getInstance(Speaker.class);
        s.say();
        s.act();
        s.jump();
    }
}
