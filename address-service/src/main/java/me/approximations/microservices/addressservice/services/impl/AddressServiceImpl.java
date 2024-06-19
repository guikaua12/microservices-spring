package me.approximations.microservices.addressservice.services.impl;

import lombok.RequiredArgsConstructor;
import me.approximations.microservices.addressservice.entities.Address;
import me.approximations.microservices.addressservice.handler.exception.NotFoundException;
import me.approximations.microservices.addressservice.repositories.AddressRepository;
import me.approximations.microservices.addressservice.services.AddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Page<Address> findAll(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Address not found."));
    }

    @Override
    public Address findByUserId(Long id) {
        return addressRepository.findByUserId(id).orElseThrow(() -> new NotFoundException("Address not found."));
    }
}
