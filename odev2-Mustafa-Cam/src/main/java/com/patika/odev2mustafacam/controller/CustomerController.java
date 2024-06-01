    package com.patika.odev2mustafacam.controller;

    import com.patika.odev2mustafacam.dto.request.CustomerSaveRequest;
    import com.patika.odev2mustafacam.dto.request.UpdateAcountTypeRequest;
    import com.patika.odev2mustafacam.dto.request.emailUpdateRequest;
    import com.patika.odev2mustafacam.dto.response.CustomerResponse;
    import com.patika.odev2mustafacam.dto.response.GenericResponse;
    import com.patika.odev2mustafacam.model.Address;
    import com.patika.odev2mustafacam.model.Customer;
    import com.patika.odev2mustafacam.service.CustomerService;
    import lombok.AllArgsConstructor;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @AllArgsConstructor
    @RestController
    @RequestMapping("/api/v1/customers")
    public class CustomerController {

        private final CustomerService customerService;

        @PostMapping
        public void save(@RequestBody CustomerSaveRequest request) {
            customerService.save(request);
        }

        @GetMapping
        public List<CustomerResponse> getAll() {
            return customerService.getCustomerList();
        }

        @GetMapping("/{id}") // PathVariable
        public GenericResponse<Customer> getById(@PathVariable Long id) {

            Customer customer = customerService.getById(id);

            return GenericResponse.success(customer);
        }

        @GetMapping("/email/{email}")
        public GenericResponse<Customer> getByEmail(@PathVariable String email) {
            Customer customer = customerService.getByEmail(email);
            return GenericResponse.success(customer);
        }

        @PatchMapping("/update/address/{customerID}")
        public GenericResponse<CustomerResponse> updateAddress( @PathVariable Long customerID, @RequestBody Address address){
            CustomerResponse customer = customerService.updateAddress(customerID,address);
            return GenericResponse.success(customer);
        }

        @PatchMapping("/update/email/{customerID}")
        public GenericResponse<CustomerResponse> updateEmail(@PathVariable Long customerID, @RequestBody emailUpdateRequest email )
        {
            CustomerResponse customer = customerService.updateEmail(customerID,email);
//            System.out.println("customerController \n"+customer);

            return GenericResponse.success(customer);
        }
        @PatchMapping("/update/acounttype/{customerID}")
        public GenericResponse<CustomerResponse> updateAcountType(@PathVariable Long customerID, @RequestBody UpdateAcountTypeRequest acountType )
        {
            CustomerResponse customer = customerService.updateAcountType(customerID,acountType);
//            System.out.println("customerController \n"+customerService.updateAcountType(customerID,acountType));
//            System.out.println("customerControllergeneric \n"+GenericResponse.success(customer));
            return GenericResponse.success(customer);
        }

    }
