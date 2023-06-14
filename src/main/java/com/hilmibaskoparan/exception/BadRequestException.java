package com.hilmibaskoparan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 1xx = Information Error
// 2xx = Success Error
// 3xx = Redirect Error
// 4xx = Client Error
// 5xx = Server Error

// 400: Bad Request
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
