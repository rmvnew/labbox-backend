package com.labbox.lab.service;

import com.labbox.lab.entities.User;
import com.labbox.lab.model.TokenModel;

public interface TokenService {
    TokenModel generateToken(User user);

    String getSubject(String token);
}
