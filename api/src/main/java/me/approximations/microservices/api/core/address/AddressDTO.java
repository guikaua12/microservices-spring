package me.approximations.microservices.api.core.address;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class AddressDTO {
    private Long id;
    private String address1;
    private String address2;
    private int zipcode;
    private Long userId;
}
