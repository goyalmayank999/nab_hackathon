package com.fps.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fps.dto.ResponseDto;
import com.fps.exception.PayeeException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.fps.constants.Constants.FAILURE_CODE;
import static com.fps.constants.Constants.STATUS_FAILURE;


/**
 *
 * Controller : Exception Handler
 *
 * @author vConnect
 *
 */


@RestControllerAdvice
@Log
public class ExceptionController {

    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDto> dmsRunTimException(RuntimeException ex) throws JsonProcessingException {

        String message = ex.getMessage();
        ResponseDto ResponseDto = new ResponseDto(STATUS_FAILURE, FAILURE_CODE, message, null, message);
        ex.printStackTrace();
        return new ResponseEntity<>(ResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PayeeException.class)
    public ResponseEntity<ResponseDto> PayeeException(PayeeException ex) throws JsonProcessingException {
        ResponseDto ResponseDto = new ResponseDto(STATUS_FAILURE, FAILURE_CODE, ex.getMessage(), null, ex.getMessage());
        ex.printStackTrace();
        return new ResponseEntity<>(ResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Object handleMethodException(MethodArgumentNotValidException ex) throws JsonProcessingException {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError= bindingResult.getFieldError();
        String message = fieldError.getDefaultMessage();
        ResponseDto ResponseDto = new ResponseDto(STATUS_FAILURE, FAILURE_CODE, message, null, message);
        ex.printStackTrace();
        return new ResponseEntity<>(ResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
