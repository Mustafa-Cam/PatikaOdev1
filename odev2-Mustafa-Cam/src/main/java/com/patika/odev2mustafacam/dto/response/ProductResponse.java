package com.patika.odev2mustafacam.dto.response;

import com.patika.odev2mustafacam.model.Customer;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private String name;
    private BigDecimal amount;
    private String description;
    private String publisherName;
//    private Customer customer;
    private String category;
}
