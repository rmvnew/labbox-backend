package com.labbox.lab.service.impl;

import com.labbox.lab.dto.UserRequestDto;
import com.labbox.lab.entities.Role;
import com.labbox.lab.entities.User;
import com.labbox.lab.repository.RolesRepository;
import com.labbox.lab.repository.UserRepository;
import com.labbox.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(UserRequestDto dto) {

        User user = new User(
                dto.getUserEnrollment(),
                dto.getUserName().toUpperCase(),
                dto.getUserEmail().toLowerCase(),
                passwordEncoder.encode(dto.getUserPassword())
        );

        Set<Role> roles = new HashSet<>();

        for (Long currentId : dto.getRolesId()) {

            var currentRoles = this.rolesRepository.findById(currentId).get();
            roles.add(currentRoles);
        }

        user.setRoles(roles);

        this.userRepository.save(user);

    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);

        if(userOptional.isPresent()){
            return  userOptional.get();
        }else{
            return null;
        }

    }

    @Override
    public User userUpdate(UserRequestDto dto, Long id) {

        User user = this.findById(id);

        if (user == null) {
            System.out.println("User not found!!");
        }

        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());

        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = this.findById(id);

        if (user == null) {
            System.out.println("User not found!!");
        }

        this.userRepository.delete(user);
    }
}
