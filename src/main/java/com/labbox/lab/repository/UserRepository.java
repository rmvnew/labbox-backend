package com.labbox.lab.repository;


import com.labbox.lab.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserEmail(String userEmail);
}
