package me.approximations.microservices.employeeservice.dtos.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.approximations.microservices.employeeservice.dtos.client.Address;
import me.approximations.microservices.employeeservice.entities.Employee;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponse {
    private final Long id;
    private final String name;
    private final BigDecimal salary;
    private final Address address;

    public EmployeeResponse(Employee employee, Address address) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.salary = employee.getSalary();
        this.address = address;
    }
}
