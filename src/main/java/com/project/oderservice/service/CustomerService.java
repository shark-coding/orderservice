package com.project.oderservice.service;

import com.project.oderservice.domain.CreateCustomer;
import com.project.oderservice.domain.Customer;
import com.project.oderservice.domain.CustomerDTO;
import com.project.oderservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerDTO newCustomer(CreateCustomer customer) {
        Customer entity = Customer.newCustomer(customer);
        Customer saved = customerRepository.save(entity);
        return CustomerDTO.builder()
                .address(saved.getAddress())
                .name(saved.getName())
                .phoneNumber(saved.getPhoneNumber())
                .build();
    }
}
