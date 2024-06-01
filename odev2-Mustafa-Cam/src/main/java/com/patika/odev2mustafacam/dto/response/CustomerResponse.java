package com.patika.odev2mustafacam.dto.response;

import com.patika.odev2mustafacam.model.Address;
import com.patika.odev2mustafacam.model.enums.AccountType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Set<Address> address;
    private Boolean isActive;
    private AccountType accountType;
}
