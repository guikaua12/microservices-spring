package me.approximations.microservices.api.core.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {
    private Long id;
    private String address1;
    private String address2;
    private int zipcode;
    private Long userId;
}
