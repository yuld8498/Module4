package com.codegym.banking.service;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}
