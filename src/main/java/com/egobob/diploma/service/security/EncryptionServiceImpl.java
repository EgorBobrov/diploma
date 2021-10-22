package com.egobob.diploma.service.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    private BCryptPasswordEncoder passwordEncoder;

    public EncryptionServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encryptString(String input){
        return passwordEncoder.encode(input);
    }

    public boolean checkPassword(String plainPassword, String encryptedPassword){
        return passwordEncoder.matches(plainPassword, encryptedPassword);
    }


}
