package com.example.SoftwarePatterns.EntityRepos;

import com.example.SoftwarePatterns.Entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
