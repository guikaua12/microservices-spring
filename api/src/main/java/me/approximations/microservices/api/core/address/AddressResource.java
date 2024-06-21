package me.approximations.microservices.api.core.address;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface AddressResource {
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable("id") Long id);

    @GetMapping
    public ResponseEntity<Page<AddressDTO>> findAll(Pageable pageable);

    @GetMapping("/user/{userId}")
    public ResponseEntity<AddressDTO> findByUserId(@PathVariable("userId") Long id);
}
