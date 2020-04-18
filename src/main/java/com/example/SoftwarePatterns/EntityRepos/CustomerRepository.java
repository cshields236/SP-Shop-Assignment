package com.example.SoftwarePatterns.EntityRepos;

import com.example.SoftwarePatterns.Entities.Customer;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    public Customer findByUsernameAndPassword(String username, String password);
}
