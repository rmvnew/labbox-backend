package com.labbox.lab.repository;


import com.labbox.lab.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role,Long> {
}
