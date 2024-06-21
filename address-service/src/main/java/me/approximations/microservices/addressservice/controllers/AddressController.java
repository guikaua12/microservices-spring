package me.approximations.microservices.addressservice.controllers;

import lombok.RequiredArgsConstructor;
import me.approximations.microservices.addressservice.entities.Address;
import me.approximations.microservices.addressservice.services.AddressService;
import me.approximations.microservices.api.core.address.AddressDTO;
import me.approximations.microservices.api.core.address.AddressResource;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController implements AddressResource {
    private final AddressService addressService;
    private final ModelMapper modelMapper;

    @Override
    public AddressDTO findById(@PathVariable("id") Long id) {
        return modelMapper.map(addressService.findById(id), AddressDTO.class);
    }

    @Override
    public Page<AddressDTO> findAll(Pageable pageable) {
        final Page<Address> addresses = addressService.findAll(pageable);
        return addresses.map(address -> modelMapper.map(address, AddressDTO.class));
    }

    @Override
    public AddressDTO findByUserId(@PathVariable("userId") Long id) {
        return modelMapper.map(addressService.findByUserId(id), AddressDTO.class);
    }
}
