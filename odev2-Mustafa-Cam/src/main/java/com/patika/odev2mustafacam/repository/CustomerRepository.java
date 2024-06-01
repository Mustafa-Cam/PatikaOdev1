package com.patika.odev2mustafacam.repository;

import com.patika.odev2mustafacam.converter.CustomerConverter;
import com.patika.odev2mustafacam.dto.request.CustomerSaveRequest;
import com.patika.odev2mustafacam.dto.request.UpdateAcountTypeRequest;
import com.patika.odev2mustafacam.dto.request.emailUpdateRequest;
import com.patika.odev2mustafacam.dto.response.CustomerResponse;
import com.patika.odev2mustafacam.model.Address;
import com.patika.odev2mustafacam.model.Customer;
import com.patika.odev2mustafacam.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    public void createCustomer(Customer customer)
    {
        customerList.add(customer);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Optional<Customer> findById(Long id) {
        return getCustomerList().stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    public Optional<Customer> findByEmail(String email) {
        return getCustomerList().stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
    }


    public Optional<Customer> updateCustomer(Long customerId, Address newAddress) {
        Optional<Customer> optionalCustomer = findById(customerId); // Müşteriyi ID'ye göre bul

        optionalCustomer.ifPresent(customer -> {
            // Müşterinin mevcut adreslerini al
            Set<Address> addresses = customer.getAddresses();

            // Yeni adresi müşterinin adreslerine ekleyerek mevcut adresi değiştir
            addresses.clear(); // Mevcut adresleri temizle
            addresses.add(newAddress); // Yeni adresi ekle
            customer.setAddresses(addresses); // Müşterinin adreslerini güncelle

            System.out.println("optionalCustomerupdate"+optionalCustomer);
        });
        return optionalCustomer;
    }


    public Optional<Customer> updateCustomerEmail(Long customerID, emailUpdateRequest email) {
        Optional<Customer> optionalCustomer = findById(customerID); // Müşteriyi ID'ye göre bul
        optionalCustomer.ifPresent(customer -> {

            // setter'ın görevi zaten güncellemek.
            customer.setEmail(email.getEmail());
            System.out.println("optionalCustomer \n" +optionalCustomer);
        });
        return optionalCustomer;
    }

    public Optional<Customer> updateAcountType(Long customerID, UpdateAcountTypeRequest acountType) {
        Optional<Customer> optionalCustomer = findById(customerID); // Müşteriyi ID'ye göre bul

        optionalCustomer.ifPresent(customer -> {

            // setter'ın görevi zaten güncellemek.
            customer.setAccountType(acountType.getAcountType());
            System.out.println("optionalCustomerAT \n" +optionalCustomer);
        });
        return optionalCustomer;
    }

    public void addOrderToCustomer(Order order, Long customerId) {

    }
}
