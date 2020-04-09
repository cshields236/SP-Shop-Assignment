package com.example.SoftwarePatterns.EntityRepos;

import com.example.SoftwarePatterns.Entities.Administrator;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {
}
