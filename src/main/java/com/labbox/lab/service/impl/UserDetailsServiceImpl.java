package com.labbox.lab.service.impl;

import com.labbox.lab.entities.Role;
import com.labbox.lab.entities.User;
import com.labbox.lab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByUserEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }

        Set<Role> roles = user.getRoles().stream()
                .map(roleName -> {
                    Role role = new Role();
                    role.setRoleName(roleName.getRoleName());
                    return role;
                })
                .collect(Collectors.toSet());



        return (UserDetails) User.builder()
                .userEmail(user.getUserEmail())
                .userPassword(user.getUserPassword())
                .roles(roles)
                .build();
    }

}
