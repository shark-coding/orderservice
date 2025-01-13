package com.project.oderservice.controller;

import com.project.oderservice.domain.CreateCustomer;
import com.project.oderservice.domain.Customer;
import com.project.oderservice.domain.CustomerDTO;
import com.project.oderservice.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/v1/customer")
    public Response<CustomerDTO> createNewCustomer(@RequestParam String name,
                                         @RequestParam String address,
                                         @RequestParam String phoneNumber) {
        return Response.success(customerService.newCustomer(
                CreateCustomer.builder()
                        .address(address)
                        .name(name)
                        .phone(phoneNumber)
                        .build()
        ));
    }
}
