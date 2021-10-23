package com.egobob.diploma.web.controller;

import org.springframework.ui.Model;

public interface BaseEntityController<T> {
    String newEntity(Model model);
    String saveEntity(T toSave);
    String showEntity(Long id, Model model);
    String list(Model model);
    String edit(Long id, Model model);
    String delete(Long id);
}
