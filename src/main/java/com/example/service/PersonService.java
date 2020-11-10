package com.example.service;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import io.reactivex.Maybe;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class PersonService {

    @Inject
    PersonRepository repository;

    public Person add(Person person) {
        return repository.add(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Maybe<Person> findById(final Integer id) {
        return Maybe.just(id)
                .subscribeOn(Schedulers.io())
                .map(it -> repository.findById(id).orElse(null));
    }

}
