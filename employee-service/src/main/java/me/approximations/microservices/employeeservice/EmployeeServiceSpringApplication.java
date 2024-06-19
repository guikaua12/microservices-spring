package me.approximations.microservices.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceSpringApplication.class);
    }
}