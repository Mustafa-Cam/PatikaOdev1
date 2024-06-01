package com.patika.odev2mustafacam.controller;

import com.patika.odev2mustafacam.dto.request.OrderSaveRequest;
import com.patika.odev2mustafacam.dto.request.ProductSaveRequest;
import com.patika.odev2mustafacam.dto.response.GenericResponse;
import com.patika.odev2mustafacam.dto.response.OrderResponse;
import com.patika.odev2mustafacam.model.Order;
import com.patika.odev2mustafacam.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody OrderSaveRequest request) {
        orderService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<List<Order>> getOrder(){
       return GenericResponse.success(orderService.getOrderList());
    }
}
