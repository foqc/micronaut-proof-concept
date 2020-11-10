package com.example.repository;

import com.example.model.Person;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class PersonRepository {
    List<Person> persons = new ArrayList<>();

    public Person add(Person person) {
        person.setId(persons.size() + 1);
        persons.add(person);
        return person;
    }

    public Optional<Person> findById(Integer id) {
        return persons.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public List<Person> findAll() {
        return persons;
    }

}
