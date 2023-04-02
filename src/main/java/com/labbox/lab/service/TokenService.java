package com.labbox.lab.service;

import com.labbox.lab.entities.User;

public interface TokenService {
    String generateToken(User user);

    String getSubject(String token);
}
