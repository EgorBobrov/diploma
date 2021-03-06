package com.egobob.diploma.service;

import java.util.List;

public interface BaseCrudService<T> {
    List<?> listAll();
    T getById(Long id);
    T saveOrUpdate(T domainObject);
    void delete(Long id);
}
