package com.example;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Dependent
public class ExampleService {

    @Inject
    EntityManager em;

    public void persistEntity(String name) {
        em.persist(new ExampleEntity(name));
    }
}
