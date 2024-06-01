package com.patika.odev2mustafacam.converter;

import com.patika.odev2mustafacam.dto.request.CustomerSaveRequest;
import com.patika.odev2mustafacam.dto.response.CustomerResponse;
import com.patika.odev2mustafacam.dto.response.ProductResponse;
import com.patika.odev2mustafacam.model.Address;
import com.patika.odev2mustafacam.model.Customer;
import com.patika.odev2mustafacam.model.Product;
import com.patika.odev2mustafacam.model.enums.AccountType;
import com.patika.odev2mustafacam.util.HashUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerConverter {

    public static Customer toCustomer(CustomerSaveRequest request) {
        String hashedPassword = HashUtil.generate(request.getPassword());

       return Customer.builder()
        .id(request.getId()).name(request.getName()).surname(request.getSurname()).email(request.getEmail())
               .password(hashedPassword).addresses(request.getAddress())
               .accountType(AccountType.STANDARD).isActive(Boolean.TRUE).build();
    }

    public static CustomerResponse toResponse(Customer customer) {

        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .address(customer.getAddresses())
                .isActive(Boolean.TRUE)
                .accountType(customer.getAccountType())
                .build();
    }

    public static List<CustomerResponse> toCustomer(List<Customer> customerList) {
        return customerList
                .stream()
                .map(CustomerConverter::toResponse)
                .collect(Collectors.toList());
    }
}
