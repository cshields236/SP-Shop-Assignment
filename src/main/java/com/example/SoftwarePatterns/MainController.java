package com.example.SoftwarePatterns;


import com.example.SoftwarePatterns.Entities.Administrator;
import com.example.SoftwarePatterns.Entities.Customer;
import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.EntityRepos.AdministratorRepository;
import com.example.SoftwarePatterns.EntityRepos.CustomerRepository;
import com.example.SoftwarePatterns.EntityRepos.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AdministratorRepository administratorRepository;

    @PostMapping(path="/addStock")
    public @ResponseBody String addNewStock(@RequestParam String title, @RequestParam String manufacturer, @RequestParam String category, @RequestParam String image, @RequestParam double price ){

        StockItem item = new StockItem(title, manufacturer, category, image, price);
        stockRepository.save(item);
        return "Saved!";

    }
//    String name, String username, String password, String address, String payment
    @PostMapping(path ="/addCustomer")
    public @ResponseBody String addNewCustomer(@RequestParam String name,@RequestParam String username, @RequestParam String password, @RequestParam String address, @RequestParam String payment){
        Customer customer = new Customer(name, username, password, address, payment);
        customerRepository.save(customer);
        return "Customer Account Created";
    }

    @PostMapping(path ="/addAdmin")
    public @ResponseBody String addNewCustomer(@RequestParam String username, @RequestParam String password){
        Administrator administrator = new Administrator( username, password);
        administratorRepository.save(administrator);
        return "Admin Account Created";

    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<StockItem> getAllStock() {
        // This returns a JSON or XML with the users
        return stockRepository.findAll();
    }
}
