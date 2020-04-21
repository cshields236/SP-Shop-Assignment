package com.example.SoftwarePatterns.EntityRepos;

import com.example.SoftwarePatterns.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
