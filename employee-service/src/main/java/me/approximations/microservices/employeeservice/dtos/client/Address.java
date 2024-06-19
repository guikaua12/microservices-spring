package me.approximations.microservices.employeeservice.dtos.client;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of="id")
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class Address {
    private final Long id;
    private String address1;
    private String address2;
    private int zipcode;
}
