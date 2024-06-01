package com.patika.odev2mustafacam.dto.request;

import com.patika.odev2mustafacam.model.Customer;
import com.patika.odev2mustafacam.model.Product;
import com.patika.odev2mustafacam.model.enums.OrderStatus;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Data

public class OrderSaveRequest {
    private List<String> productNameList;
    private Long customerId;
}
