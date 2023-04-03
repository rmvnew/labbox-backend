package com.labbox.lab.controller;

import com.labbox.lab.dto.UserRequestDto;
import com.labbox.lab.entities.User;
import com.labbox.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public void createUser(@RequestBody UserRequestDto dto) {
        this.userService.create(dto);
    }


    @GetMapping()
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public User findById(
            @PathVariable Long id
    ) {
        return this.userService.findById(id);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto dto
    ) {
        return this.userService.userUpdate(dto, id);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUser(
            @PathVariable Long id
    ) {
        this.userService.deleteUser(id);
    }

}
