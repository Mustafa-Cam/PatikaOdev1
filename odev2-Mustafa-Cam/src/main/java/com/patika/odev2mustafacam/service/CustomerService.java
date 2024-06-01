package com.patika.odev2mustafacam.service;

import com.patika.odev2mustafacam.converter.CustomerConverter;
import com.patika.odev2mustafacam.dto.request.CustomerSaveRequest;
import com.patika.odev2mustafacam.dto.request.UpdateAcountTypeRequest;
import com.patika.odev2mustafacam.dto.request.emailUpdateRequest;
import com.patika.odev2mustafacam.dto.response.CustomerResponse;
import com.patika.odev2mustafacam.exception.ExceptionMessages;
import com.patika.odev2mustafacam.exception.KitapYurdumException;
import com.patika.odev2mustafacam.model.Address;
import com.patika.odev2mustafacam.model.Customer;
import com.patika.odev2mustafacam.model.Product;
import com.patika.odev2mustafacam.model.enums.AccountType;
import com.patika.odev2mustafacam.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository; //yönetim artık spring'te

    public void save(CustomerSaveRequest request) {

        Optional<Customer> foundCustomer = customerRepository.findByEmail(request.getEmail()); // Clientten gelen mail'e göre repository'den customer bul.

        if (foundCustomer.isPresent())// Optional'in fonksiyonu isPresent değer varsa True yoksa false Döner.
            // yani burda foundCustomer dolu ise bu email de zaten kullanıcı vardır diyor ve error log'u veriyor.
            //ardından custom exception ile hata fırlatıyoruz.
        {
            log.error(ExceptionMessages.EMAIL_ALREADY_EXIST);
            throw new KitapYurdumException(ExceptionMessages.EMAIL_ALREADY_EXIST);
        }

        Customer customer = CustomerConverter.toCustomer(request);// converter'ın amacı dtodan gelen veriyi işlemek ve burda Cutomer objesine çevirmek.

        customerRepository.createCustomer(customer); // converter da işlenen customer objesi repository ile array'e ekleniyor ileride db'e eklenecek.

        log.info("customer created. {}", customer.getEmail());


    }

    public List<CustomerResponse> getCustomerList() {
        log.info("{}",customerRepository.getCustomerList());
        return CustomerConverter.toCustomer( customerRepository.getCustomerList());
    }

    public void changeAccountType(Long id, AccountType accountType) {

        Optional<Customer> foundCustomer = customerRepository.findById(id);

        foundCustomer.ifPresent(customer -> customer.setAccountType(accountType));
    }

    public void changeAccountTypeByCredit(Long id, AccountType accountType) { //ödev

    }

    public Customer getById(Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);

        if (foundCustomer.isEmpty()) {
            log.error(ExceptionMessages.CUSTOMER_NOT_FOUND);
            throw new KitapYurdumException(ExceptionMessages.CUSTOMER_NOT_FOUND);
        }

        return foundCustomer.get();
    }

    public Customer getByEmail(String email) {

        Optional<Customer> foundCustomer = customerRepository.findByEmail(email);

        if (!foundCustomer.get().getIsActive()) {
            log.error(ExceptionMessages.CUSTOMER_NOT_ACTIVE);
            throw new KitapYurdumException(ExceptionMessages.CUSTOMER_NOT_ACTIVE);
        }

        return foundCustomer.get();
    }

    public CustomerResponse updateAddress(Long CustomerId,Address address) {
        Optional<Customer> updatedCustomer = customerRepository.updateCustomer(CustomerId,address);
        System.out.println("updatedcustomer \n"+updatedCustomer);

        if (!updatedCustomer.get().getIsActive()) {
            log.error(ExceptionMessages.CUSTOMER_NOT_ACTIVE);
            throw new KitapYurdumException(ExceptionMessages.CUSTOMER_NOT_ACTIVE);
        }
        System.out.println("updatedCustomer \n"+updatedCustomer);
        System.out.println("updatedCustomer get \n"+updatedCustomer.get());
        return CustomerConverter.toResponse(updatedCustomer.get());
    }

    public CustomerResponse updateEmail(Long customerID, emailUpdateRequest email) {
        Optional<Customer> updatedCustomer = customerRepository.updateCustomerEmail(customerID,email);

        return CustomerConverter.toResponse(updatedCustomer.get());
    }

    public CustomerResponse updateAcountType(Long customerID, UpdateAcountTypeRequest acountType) {
        Optional<Customer> updatedAcountType = customerRepository.updateAcountType(customerID,acountType);
        System.out.println("updateAcountTypeservice \n"+updatedAcountType);
        return CustomerConverter.toResponse(updatedAcountType.get());
    }

    public void increaseCreditByTwoPercent(List<String> productName, Long customerId) {

    }
}
