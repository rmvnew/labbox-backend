package com.labbox.lab.exception;

public class CustomException extends RuntimeException {
    private ErrorCustom errorCustom;

    public CustomException(ErrorCustom errorCustom) {
        this.errorCustom = errorCustom;
    }

    public ErrorModel getStatus() {
        return new ErrorModel(
                errorCustom.getHttpStatus(),
                errorCustom.getCode(),
                errorCustom.getMessage());
    }

}
