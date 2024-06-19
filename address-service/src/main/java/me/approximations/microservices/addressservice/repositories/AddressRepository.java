package me.approximations.microservices.addressservice.repositories;

import me.approximations.microservices.addressservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
