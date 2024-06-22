package me.approximations.microservices.employeeservice.clients;

import me.approximations.microservices.api.core.address.AddressResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="address-service", path="/address")
public interface AddressServiceClient extends AddressResource {
}
