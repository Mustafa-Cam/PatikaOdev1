package com.patika.odev2mustafacam.model;

import com.patika.odev2mustafacam.model.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Order {

    private LocalDateTime createDate;
    private List<Product> productList;
    private String orderCode; //-ordercode generate
    private OrderStatus orderStatus;
    private Customer customer;
    }
