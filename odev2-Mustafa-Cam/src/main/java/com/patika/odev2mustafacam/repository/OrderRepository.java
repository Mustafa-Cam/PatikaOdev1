package com.patika.odev2mustafacam.repository;

import com.patika.odev2mustafacam.dto.request.OrderSaveRequest;
import com.patika.odev2mustafacam.model.Customer;
import com.patika.odev2mustafacam.model.Order;
import com.patika.odev2mustafacam.model.Product;
import com.patika.odev2mustafacam.service.OrderService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class OrderRepository {

    private final List<Order> orderList;

    public void createOrder(Order order) {
        orderList.add(order);
    }

    public OrderRepository(){
        orderList = new ArrayList<>();
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
