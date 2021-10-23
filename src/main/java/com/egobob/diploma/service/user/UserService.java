package com.egobob.diploma.service.user;

import com.egobob.diploma.domain.User;
import com.egobob.diploma.service.BaseCrudService;

public interface UserService extends BaseCrudService<User> {
    User findByUsername(String username);
    void save(User user);
}
