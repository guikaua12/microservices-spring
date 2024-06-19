package me.approximations.microservices.employeeservice.handler;

import me.approximations.microservices.employeeservice.handler.exception.StatusCodeException;
import me.approximations.microservices.employeeservice.handler.response.CustomErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StatusCodeException.class)
    public ResponseEntity<Object> handleStatusCodeException(StatusCodeException exception, WebRequest request) {
        final CustomErrorResponse response = new CustomErrorResponse(exception.getStatus().value(), exception.getMessage());

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(exception, response, headers, exception.getStatus(), request);
    }
}
