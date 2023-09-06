package com.example.springexample.services;

import java.util.Collection;


public interface CRUDService<T> {

    T getById(Integer id);

    Collection<T> getAll();

    void create(T dto);

    void update(T dto);

    T deleteById(Integer id);
}
