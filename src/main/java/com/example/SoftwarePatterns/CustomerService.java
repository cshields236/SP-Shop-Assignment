package com.example.SoftwarePatterns;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.example.SoftwarePatterns.Entities.Customer;
import com.example.SoftwarePatterns.EntityRepos.CustomerRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveMyCustomer(Customer customer ) {
        customerRepository.save(customer);
    }


    public Customer findByUsernameAndPassword(String username, String password) {
        return customerRepository.findByUsernameAndPassword(username, password);
    }
}