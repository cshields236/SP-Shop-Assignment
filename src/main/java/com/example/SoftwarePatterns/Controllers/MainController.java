package com.example.SoftwarePatterns.Controllers;


import com.example.SoftwarePatterns.Entities.Administrator;
import com.example.SoftwarePatterns.Entities.Customer;
import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.EntityRepos.AdministratorRepository;
import com.example.SoftwarePatterns.EntityRepos.CustomerRepository;
import com.example.SoftwarePatterns.EntityRepos.StockRepository;
import com.example.SoftwarePatterns.Services.CustomerService;
import com.example.SoftwarePatterns.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/")
public class MainController {
    @Autowired
    private StockRepository stockService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private CustomerService customerService;



    @RequestMapping("/welcome")
    public String Welcome(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "welcome";
    }

    @RequestMapping("/register")
    public String registration(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_REGISTER");
        return "welcome";
    }

    @GetMapping(path = "/add-Customer")
    public @ResponseBody
    Customer addNewCustomer(@RequestParam String name, @RequestParam String username, @RequestParam String password, @RequestParam String address, @RequestParam String payment) {
        Customer customer = new Customer(name, username, password, address, payment);
        return customerRepository.save(customer);

    }

    @PostMapping(path = "/addAdmin")
    public @ResponseBody
    String addNewCustomer(@RequestParam String username, @RequestParam String password) {
        Administrator administrator = new Administrator(username, password);
        administratorRepository.save(administrator);
        return "Admin Account Created";

    }


    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_LOGIN");
        return "welcome";
    }

    @RequestMapping("/login-user")
    public String loginUser(@ModelAttribute Customer customer, HttpServletRequest request) {
        if (customerService.findByUsernameAndPassword(customer.getUsername(), customer.getPassword()) != null) {
            request.setAttribute("mode", "STORE_ITEMS");
            return "welcome";
        } else {
            request.setAttribute("error", "Invalid Username or Password");
            request.setAttribute("mode", "MODE_LOGIN");
            return "welcome";

        }
    }



    @PostMapping(path = "/addStock")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    String addNewStock(@RequestParam String title, @RequestParam String manufacturer, @RequestParam String category, @RequestParam String image, @RequestParam double price, @RequestParam int quantity) {

        StockItem item = new StockItem(title, manufacturer, category, image, price, quantity);
        stockService.save(item);
        return "Saved!";

    }

    @GetMapping(path = "/show-stock")
    public String getAll(HttpServletRequest request) {
        // This returns a JSON or XML with the users
        Iterable<StockItem> getAllStocks = stockService.findAll();
        request.setAttribute("Items", getAllStocks);
        request.setAttribute("mode", "STORE_ITEMS");
        return "welcome";
    }
}
