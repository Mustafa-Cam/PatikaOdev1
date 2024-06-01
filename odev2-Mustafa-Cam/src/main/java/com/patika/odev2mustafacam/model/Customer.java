package com.patika.odev2mustafacam.model;


import com.patika.odev2mustafacam.model.enums.AccountType;
import lombok.*;

import java.util.Set;

// Lombok kodları azaltmak için kullanılıyor. Sürekli tekrar eden kodları bu şekilde kullanıyoruz.
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Customer {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer credit;
    private String phoneNumber;
    private Set<Address> addresses;
    private Boolean isActive;
    private AccountType accountType;

    public Customer(String name, String surname, String email, String password,Set<Address> address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.addresses = address;
    }
}
