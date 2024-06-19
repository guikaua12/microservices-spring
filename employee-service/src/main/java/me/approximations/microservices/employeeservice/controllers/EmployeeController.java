package me.approximations.microservices.employeeservice.controllers;

import lombok.RequiredArgsConstructor;
import me.approximations.microservices.employeeservice.clients.AddressServiceClient;
import me.approximations.microservices.employeeservice.dtos.client.Address;
import me.approximations.microservices.employeeservice.dtos.employee.EmployeeResponse;
import me.approximations.microservices.employeeservice.entities.Employee;
import me.approximations.microservices.employeeservice.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final AddressServiceClient addressServiceClient;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable("id") Long id) {
        final Employee employee = employeeService.findById(id);
        final Address address = addressServiceClient.findByUserId(employee.getId());

        return ResponseEntity.ok(new EmployeeResponse(employee, address));
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> findAll(Pageable pageable) {
        return ResponseEntity.ok(employeeService.findAll(pageable));
    }
}
