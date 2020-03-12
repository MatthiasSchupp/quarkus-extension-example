package com.example.application;

import com.example.ExampleService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("example")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class ExampleResource {

    @Inject
    ExampleService exampleService;

    @POST
    public void example(@QueryParam("name") String name) {
        exampleService.persistEntity(name);
    }
}
