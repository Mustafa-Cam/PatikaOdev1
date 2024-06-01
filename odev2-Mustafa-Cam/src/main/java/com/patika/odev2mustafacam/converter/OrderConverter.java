package com.patika.odev2mustafacam.converter;

import com.patika.odev2mustafacam.dto.request.CustomerSaveRequest;
import com.patika.odev2mustafacam.dto.request.OrderSaveRequest;
import com.patika.odev2mustafacam.dto.response.CustomerResponse;
import com.patika.odev2mustafacam.dto.response.OrderResponse;
import com.patika.odev2mustafacam.model.Customer;
import com.patika.odev2mustafacam.model.Order;
import com.patika.odev2mustafacam.model.enums.AccountType;
import com.patika.odev2mustafacam.model.enums.OrderStatus;
import com.patika.odev2mustafacam.service.CustomerService;
import com.patika.odev2mustafacam.service.OrderService;
import com.patika.odev2mustafacam.service.ProductService;
import com.patika.odev2mustafacam.util.GenerateCode;
import com.patika.odev2mustafacam.util.HashUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;



@Component
@RequiredArgsConstructor
public class OrderConverter {


    private final CustomerService customerService;
    private final ProductService productService;
    private final GenerateCode generateOrderCode;



    public   Order toOrder(OrderSaveRequest request) {


        return Order.builder()
                .createDate(LocalDateTime.now())
                .orderStatus(OrderStatus.INITIAL)
                .customer(customerService.getById(request.getCustomerId()))
                .productList(productService.getProductListByNames( request.getProductNameList()))
                .orderCode(generateOrderCode.generateOrderCode())
                .build();

    }

    public static OrderResponse toResponse(Order order) {

        return OrderResponse.builder()
                .createDate(LocalDateTime.now())
                .orderStatus(OrderStatus.INITIAL)
                .productList(order.getProductList())
                .orderCode(order.getOrderCode())
                .build();
    }

    public static List<OrderResponse> toOrder(List<Order> orderList) {
        return orderList
                .stream()
                .map(OrderConverter::toResponse)
                .collect(Collectors.toList());
    }



}
