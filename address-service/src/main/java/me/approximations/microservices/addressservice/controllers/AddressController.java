package me.approximations.microservices.addressservice.controllers;

import lombok.RequiredArgsConstructor;
import me.approximations.microservices.addressservice.entities.Address;
import me.approximations.microservices.addressservice.services.AddressService;
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
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Address>> findAll(Pageable pageable) {
        return ResponseEntity.ok(addressService.findAll(pageable));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Address> findByUserId(@PathVariable("userId") Long id) {
        return ResponseEntity.ok(addressService.findByUserId(id));
    }
}
