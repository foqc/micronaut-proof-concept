package com.example.service;

import com.example.model.Person;
import com.example.repository.PersonRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class PersonService {

    @Inject
    PersonRepository repository;

    public Person add(Person person) {
        return repository.add(person);
    }

    public Optional<Person> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

}
