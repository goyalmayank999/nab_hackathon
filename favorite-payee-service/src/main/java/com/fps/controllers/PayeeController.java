package com.fps.controllers;

import com.fps.dto.ResponseDto;
import com.fps.exception.PayeeException;
import com.fps.services.PayeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigInteger;

@RestController
public class PayeeController {

        @Autowired
        private PayeeService payeeService;

        @GetMapping(value = "/payee-service/api/v1/payees", consumes = "application/json", produces = "application/json")
        public ResponseEntity<ResponseDto> uploadFile(@RequestHeader HttpHeaders httpHeaders, @RequestParam BigInteger customerId, @RequestParam Integer pageNo) throws IOException, PayeeException {
                ResponseDto responseDto = payeeService.getListOfFavouritePayee(customerId,pageNo);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
        }
