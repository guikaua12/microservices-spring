package me.approximations.microservices.employeeservice.controllers;

import lombok.RequiredArgsConstructor;
import me.approximations.microservices.api.core.address.AddressDTO;
import me.approximations.microservices.api.core.employee.EmployeeDTO;
import me.approximations.microservices.api.core.employee.EmployeeResource;
import me.approximations.microservices.employeeservice.clients.AddressServiceClient;
import me.approximations.microservices.employeeservice.entities.Employee;
import me.approximations.microservices.employeeservice.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController implements EmployeeResource {
    private final EmployeeService employeeService;
    private final AddressServiceClient addressServiceClient;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDTO findById(@PathVariable("id") Long id) {
        final Employee employee = employeeService.findById(id);
        final AddressDTO address = addressServiceClient.findByUserId(employee.getId());

        final EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        employeeDTO.setAddress(address);

        return employeeDTO;
    }

    @Override
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        final Page<Employee> employees = employeeService.findAll(pageable);
        return employees.map(employee -> modelMapper.map(employee, EmployeeDTO.class));
    }
}
