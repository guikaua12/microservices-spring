package me.approximations.microservices.employeeservice.services;

import me.approximations.microservices.employeeservice.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(Long id);
}
