package me.approximations.microservices.employeeservice.services.impl;

import lombok.RequiredArgsConstructor;
import me.approximations.microservices.employeeservice.entities.Employee;
import me.approximations.microservices.employeeservice.handler.exception.NotFoundException;
import me.approximations.microservices.employeeservice.repositories.EmployeeRepository;
import me.approximations.microservices.employeeservice.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found."));
    }
}
