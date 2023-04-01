package com.labbox.lab.controller;

import com.labbox.lab.dto.UserRequestDto;
import com.labbox.lab.entities.User;
import com.labbox.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping()
    public void createUser(@RequestBody UserRequestDto dto) {
        this.userService.create(dto);
    }


    @GetMapping()
    public List<User> findAll() {
        return this.userService.findAll();
    }

    //    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/{id}")
    public User findById(
            @PathVariable Long id
    ) {
        return this.userService.findById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto dto
    ) {
        return this.userService.userUpdate(dto, id);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(
            @PathVariable Long id
    ) {
        this.userService.deleteUser(id);
    }

}
