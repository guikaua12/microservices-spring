package me.approximations.microservices.employeeservice.handler.response;

import lombok.Builder;
import lombok.Data;

@Data
public class CustomErrorResponse {
    private final int status;
    private final String error;
}
