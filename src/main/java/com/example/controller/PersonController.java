package com.example.controller;

import com.example.model.Person;
import com.example.service.PersonService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Maybe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

@Controller("/persons")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Inject
    PersonService service;

    @Post(produces = MediaType.APPLICATION_JSON)
    public Person add(@Body Person person) {
        LOGGER.info("Person add: {}", person);
        return service.add(person);
    }

    @Get(uri="/{id}", produces = MediaType.APPLICATION_JSON)
    public Maybe<Person> findById(Integer id) {
        LOGGER.info("Person find: id={}", id);
        return service.findById(id);
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List findAll() {
        LOGGER.info("Person find");
        return service.findAll();
    }
}