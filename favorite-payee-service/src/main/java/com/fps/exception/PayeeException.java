package com.fps.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PayeeException extends Exception{


    private String statusCode;
    private String message;
    private transient Object errorMessages;

    public PayeeException(String errorCode, String message, String errorMessage) {
        this.statusCode = errorCode;
        this.message = message;
        this.errorMessages = errorMessage;
    }


    public PayeeException(String errorCode, String message) {
        this.statusCode = errorCode;
        this.message = message;
    }
}
