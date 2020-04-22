package com.example.SoftwarePatterns.Services;


import javax.transaction.Transactional;

import com.example.SoftwarePatterns.Entities.User;
import com.example.SoftwarePatterns.EntityRepos.UserRepository;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveMyCustomer(User user) {
        userRepository.save(user);
    }


    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}