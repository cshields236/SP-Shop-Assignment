package com.example.SoftwarePatterns.Controllers;


import com.example.SoftwarePatterns.Entities.Customer;

import com.example.SoftwarePatterns.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    @Autowired
    private CustomerService customerService;
    // inject via application.properties
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome() {

        return "welcome";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        customerService.saveMyCustomer(customer);
        return "welecome";
    }
}
