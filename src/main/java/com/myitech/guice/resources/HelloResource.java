package com.myitech.guice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api")
public class HelloResource {

    @GET
    @Path("/hello")
    public String say() {
        return "Hello Guice!";
    }
}
