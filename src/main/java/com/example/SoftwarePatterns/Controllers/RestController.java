package com.example.SoftwarePatterns.Controllers;


import com.example.SoftwarePatterns.Entities.User;

import com.example.SoftwarePatterns.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    @Autowired
    private UserService userService;
    // inject via application.properties
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome() {

        return "welcome";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        userService.saveMyCustomer(user);
        return "welecome";
    }
}
