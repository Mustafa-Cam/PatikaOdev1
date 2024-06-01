package com.patika.odev2mustafacam.dto.response;

import com.patika.odev2mustafacam.model.Product;
import com.patika.odev2mustafacam.model.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private LocalDateTime createDate;
    private List<Product> productList;
    private String orderCode;
    private OrderStatus orderStatus;
}
