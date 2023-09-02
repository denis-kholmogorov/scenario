package com.example.springexample.services;

import java.util.Collection;
import java.util.List;

/**
 * CRUDService
 */
public interface CRUDService<T> {

    T getById(Integer id);

    Collection<T> getAll();

    void create(T dto);

    void update(T dto);

    T deleteById(Integer id);
}
