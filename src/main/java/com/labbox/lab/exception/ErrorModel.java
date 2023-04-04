package com.labbox.lab.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorModel {

    private HttpStatus httpStatus;
    private Integer code;
    private String message;

}
