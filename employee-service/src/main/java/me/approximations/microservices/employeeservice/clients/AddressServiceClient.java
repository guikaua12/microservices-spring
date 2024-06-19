package me.approximations.microservices.employeeservice.clients;

import me.approximations.microservices.employeeservice.dtos.client.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="address-service", url="http://localhost:8081/address")
public interface AddressServiceClient {
    @GetMapping("/user/{id}")
    Address findByUserId(@PathVariable("id") Long id);
}
