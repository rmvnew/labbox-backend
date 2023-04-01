package com.labbox.lab.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userEnrollment;
    private Set<Long> rolesId;
}
