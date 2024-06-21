package me.approximations.microservices.api.core.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmployeeResource {
    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Long id);

    @GetMapping
    public Page<EmployeeDTO> findAll(Pageable pageable);
}
