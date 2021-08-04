package com.infoshareacademy.kulturalniweb.repository;

import java.util.Collection;

public interface Dao<T> {

    T find(Integer id);

    Collection<T> findAll();

    void save(T t);

    T update(T t);

    void delete(T t);
}
