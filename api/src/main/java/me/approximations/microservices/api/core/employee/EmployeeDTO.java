package me.approximations.microservices.api.core.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.approximations.microservices.api.core.address.AddressDTO;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private BigDecimal salary;
    private AddressDTO address;
}
