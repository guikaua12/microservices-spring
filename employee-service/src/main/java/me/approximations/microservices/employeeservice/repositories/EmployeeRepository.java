package me.approximations.microservices.employeeservice.repositories;

import me.approximations.microservices.employeeservice.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
