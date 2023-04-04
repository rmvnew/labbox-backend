package com.labbox.lab.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCustom {

    OK(HttpStatus.OK, 200, "Success"),
    CREATED(HttpStatus.CREATED, 201, "Created"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "Bad Request"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, 401, "Unauthorized"),
    FORBIDDEN(HttpStatus.FORBIDDEN, 403, "Forbidden"),
    NOT_FOUND(HttpStatus.NOT_FOUND, 404, "Not Found");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    ErrorCustom(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
