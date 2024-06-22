package me.approximations.microservices.addressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressServiceSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(AddressServiceSpringApplication.class);
    }
}