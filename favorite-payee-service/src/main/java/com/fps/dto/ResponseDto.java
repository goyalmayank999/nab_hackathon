package com.fps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String status;
    private String statusCode;
    private String message;
    private Object response;
    private Object errorResponse;

    public ResponseDto(String status, String statusCode , String message, Object response)
    {
        this.status = status;
        this.message = message;
        this.response = response;
        this.statusCode = statusCode;
    }
}
