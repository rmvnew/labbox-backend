package com.labbox.lab.service;

import com.labbox.lab.dto.UserRequestDto;
import com.labbox.lab.entities.User;

import java.util.List;

public interface UserService {

    void create(UserRequestDto dto);

    List<User> findAll();

    User findById(Long id);

    User userUpdate(UserRequestDto dto, Long id);

    void deleteUser(Long id);

}
