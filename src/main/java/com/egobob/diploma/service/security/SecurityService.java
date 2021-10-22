package com.egobob.diploma.service.security;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
