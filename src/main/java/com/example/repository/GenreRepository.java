package com.example.repository;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.model.Genre;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Singleton
public class GenreRepository {
    private final EntityManager entityManager;

    public GenreRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @ReadOnly
    public Optional<Genre> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(Genre.class, id));
    }

    @TransactionalAdvice
    public Genre save(@NotBlank String name) {
        Genre genre = new Genre();
        genre.setName(name);
        entityManager.persist(genre);
        return genre;
    }

    @ReadOnly
    public List<Genre> findAll() {
        String qlString = "SELECT g FROM Genre as g";
        TypedQuery<Genre> query = entityManager.createQuery(qlString, Genre.class);
        query.setMaxResults(10);

        return query.getResultList();
    }
}