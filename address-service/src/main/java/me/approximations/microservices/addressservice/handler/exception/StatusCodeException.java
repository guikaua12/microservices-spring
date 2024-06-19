package me.approximations.microservices.addressservice.handler.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class StatusCodeException extends RuntimeException {
    protected final HttpStatus status;

    public StatusCodeException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
