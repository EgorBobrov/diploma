package com.egobob.diploma.service;

import com.egobob.diploma.domain.User;

public interface UserService extends BaseCrudService<User> {
    User findByUsername(String username);
}
