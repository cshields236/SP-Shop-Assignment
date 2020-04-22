package com.example.SoftwarePatterns.Controllers;


import com.example.SoftwarePatterns.Entities.Administrator;
import com.example.SoftwarePatterns.Entities.Role;
import com.example.SoftwarePatterns.Entities.User;
import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.EntityRepos.AdministratorRepository;
import com.example.SoftwarePatterns.EntityRepos.UserRepository;
import com.example.SoftwarePatterns.EntityRepos.StockRepository;
import com.example.SoftwarePatterns.Services.UserService;
import com.example.SoftwarePatterns.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.Transient;
import java.util.*;

@Controller
@RequestMapping(path = "/")
public class MainController {
    @Autowired
    private StockRepository stockService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private UserService userService;


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

    @PostMapping(path = "/add-Customer")
    public @ResponseBody
    String addNewCustomer(@RequestParam String name, @RequestParam String username, @RequestParam String password, @RequestParam String address, @RequestParam String payment, @RequestParam String r) {

        List<Role> roles = new ArrayList<>();


        roles.add(new Role(r));
        User user = new User(name, username, password, address, payment, roles);


        userService.saveMyCustomer(user);


        return "welcome";

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
    public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
        if (userService.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
            request.setAttribute("mode", "STORE_ITEMS");
            return "welcome";
        } else {
            request.setAttribute("error", "Invalid Username or Password");
            request.setAttribute("mode", "MODE_LOGIN");
            return "welcome";

        }
    }

    @RequestMapping("/addProduct")
    public String addProduct(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_ADD_Product");
        return "welcome";
    }

    @PostMapping(path = "/addStock")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    String addNewStock(@RequestParam String title, @RequestParam String manufacturer, @RequestParam String category, @RequestParam String image, @RequestParam double price, @RequestParam int quantity, HttpServletRequest request) {

        StockItem item = new StockItem(title, manufacturer, category, image, price, quantity);
        stockService.save(item);
        return "welcome";

    }


    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        stockService.delete(stockService.findById(id));
        return "welcome";
    }

    @PutMapping("/stockItem/{id}")
    public String updateProduct(@PathVariable(value = "id") int itemID, HttpServletRequest request) {


        StockItem stockItem = stockService.findById(itemID);
        stockItem.setTitle(stockItem.getTitle());
        stockItem.setManufacturer(stockItem.getManufacturer());
        stockItem.setCategory(stockItem.getCategory());
        stockItem.setImage(stockItem.getImage());
        stockItem.setPrice(stockItem.getPrice());
        stockItem.setQuantity(stockItem.getQuantity() - 1);


        stockService.save(stockItem);
        return "welcome";
    }


    @RequestMapping("/edit-stock/{id}")
    public String editStock(@PathVariable(value = "id") int itemID, HttpServletRequest httpServletRequest) {
        StockItem stockItem1 = stockService.findById(itemID);
        httpServletRequest.setAttribute("stock", stockItem1);
        if (stockItem1 != null) {
            httpServletRequest.setAttribute("mode", "MODE_EDIT");
            return "welcome";
        } else {
            httpServletRequest.setAttribute("mode", "MODE_HOME");
        }
        return "welcome";
    }


    @GetMapping(path = "/show-stock")
    public String getAll(HttpServletRequest request) {
        Iterable<StockItem> getAllStocks = stockService.findAll();
        request.setAttribute("Items", getAllStocks);
        request.setAttribute("mode", "STORE_ITEMS");
        return "welcome";
    }


    @GetMapping(path = "/show-stock-searched/{title}")
    public String getSearched(HttpServletRequest request, @PathVariable(value = "title") String title) {
        Iterable<StockItem> getAllStocks = stockService.findByTitle(title);
        request.setAttribute("Items", getAllStocks);
        request.setAttribute("mode", "STORE_ITEMS_SEARCH");
        return "welcome";
    }
}
