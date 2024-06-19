package me.approximations.microservices.addressservice.handler.response;

import lombok.Data;

@Data
public class CustomErrorResponse {
    private final int status;
    private final String error;
}
