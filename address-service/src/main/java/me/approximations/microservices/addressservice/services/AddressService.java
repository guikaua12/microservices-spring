package me.approximations.microservices.addressservice.services;

import me.approximations.microservices.addressservice.entities.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {
    Page<Address> findAll(Pageable pageable);

    Address findById(Long id);

    Address findByUserId(Long id);
}
