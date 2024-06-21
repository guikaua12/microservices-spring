package me.approximations.microservices.addressservice.controllers;

import lombok.RequiredArgsConstructor;
import me.approximations.microservices.addressservice.entities.Address;
import me.approximations.microservices.addressservice.services.AddressService;
import me.approximations.microservices.api.core.address.AddressResource;
import me.approximations.microservices.api.core.address.AddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController implements AddressResource {
    private final AddressService addressService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(modelMapper.map(addressService.findById(id), AddressDTO.class));
    }

    @GetMapping
    public ResponseEntity<Page<AddressDTO>> findAll(Pageable pageable) {
        final Page<Address> addresses = addressService.findAll(pageable);
        return ResponseEntity.ok(addresses.map(address -> modelMapper.map(address, AddressDTO.class)));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<AddressDTO> findByUserId(@PathVariable("userId") Long id) {
        return ResponseEntity.ok(modelMapper.map(addressService.findByUserId(id), AddressDTO.class));
    }
}
