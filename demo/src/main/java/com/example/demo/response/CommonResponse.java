package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@ToString
public class CommonResponse<T>{
    private String message;
    private int statusCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public CommonResponse(String message, int statusCode, T data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }
    public CommonResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    public CommonResponse(HttpStatus status, T data) {
        this.data = data;
        this.statusCode = status.value();
        this.message = status.getReasonPhrase();
    }
    public CommonResponse(HttpStatus status) {
        this.statusCode = status.value();
        this.message = status.getReasonPhrase();
    }

    public CommonResponse(String message, HttpStatus status) {
        this.statusCode = status.value();
        this.message = message;
    }

    public CommonResponse() {
    }
}
