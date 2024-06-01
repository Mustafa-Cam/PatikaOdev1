package com.patika.odev2mustafacam.service;


import com.patika.odev2mustafacam.converter.OrderConverter;
import com.patika.odev2mustafacam.dto.request.OrderSaveRequest;
import com.patika.odev2mustafacam.dto.response.OrderResponse;
import com.patika.odev2mustafacam.model.Customer;
import com.patika.odev2mustafacam.model.Order;
import com.patika.odev2mustafacam.model.Product;
import com.patika.odev2mustafacam.model.enums.AccountType;
import com.patika.odev2mustafacam.repository.OrderRepository;
import com.patika.odev2mustafacam.repository.CustomerRepository;
import com.patika.odev2mustafacam.util.GenerateCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {



    @Autowired
    private OrderConverter orderConverter;

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;



    // amacım order verilince orderı veren customer'in orderlist kısmına verilen order'ı eklemek.
    public void create(OrderSaveRequest orderSaveRequest){
//        Order order = OrderConverter.toResponse
         Order order = orderConverter.toOrder(orderSaveRequest);
        orderRepository.createOrder(order);
//        System.out.println("order \n"+order);

         Customer customer =  customerService.getById(orderSaveRequest.getCustomerId());
         AccountType acountType= customer.getAccountType();

        customerRepository.addOrderToCustomer(order,orderSaveRequest.getCustomerId());

        customerService.increaseCreditByTwoPercent(orderSaveRequest.getProductNameList(),orderSaveRequest.getCustomerId());

        customerService.changeAccountTypeByCredit(orderSaveRequest.getCustomerId(),acountType);
    }

    public  List<Order> getOrderList() {
        return orderRepository.getOrderList();
    }

    public void getProductCount(String name) {

        long productCount = getOrderList().stream()
                .filter(order -> name.equals(order.getCustomer().getName()))
                .mapToLong(order -> order.getProductList().size())
                .sum();

        System.out.println(name+"in toplam ürün sayısı: " + productCount);
    }


//    private static Order prepareOrder(List<Product> productList) {
//        //Order order = new Order(); tercih etmiyoruz. çünkü direkt dönüş yapıyoruz.
//        return new Order(productList, "order23");
//    }


//        orderList.forEach(System.out::println);

}
