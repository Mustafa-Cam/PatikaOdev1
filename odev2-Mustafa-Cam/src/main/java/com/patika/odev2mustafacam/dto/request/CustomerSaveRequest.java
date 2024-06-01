package com.patika.odev2mustafacam.dto.request;

import com.patika.odev2mustafacam.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest { // DTO da client'den gelen değerleri belirtiyoruz. postmande nasıl atacaksan ona göer uyumlu type seçmelisin.
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Set<Address> address;
}
