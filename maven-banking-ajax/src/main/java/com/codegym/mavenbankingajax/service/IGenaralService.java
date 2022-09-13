package com.codegym.mavenbankingajax.service;

import java.util.Optional;

public interface IGenaralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
