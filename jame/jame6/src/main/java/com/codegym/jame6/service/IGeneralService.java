package com.codegym.jame6.service;

import com.codegym.jame6.model.Customer;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}