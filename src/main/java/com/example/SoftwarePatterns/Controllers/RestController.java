package com.example.SoftwarePatterns.Controllers;


import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.Entities.User;

import com.example.SoftwarePatterns.Services.StockService;
import com.example.SoftwarePatterns.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RestController {


    @Autowired
    private UserService userService;
    @Autowired
    private StockService stockService;


    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        userService.saveMyCustomer(user);
        return "welcome";
    }

    @PostMapping("/add-stock")
    public String addStock (@ModelAttribute StockItem stockItem, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        stockService.saveStock(stockItem);
        httpServletRequest.setAttribute("mode", "STORE_ITEMS");
        return "welcome";
    }

//    @RequestMapping("/edit-stock/{id}")
//    public String editStock(@PathVariable(value = "id") int itemID, HttpServletRequest httpServletRequest) {
//        httpServletRequest.setAttribute("mode", "MODE_EDIT");
//        StockItem stockItem1 =  stockService.findById(itemID);
//        httpServletRequest.setAttribute("stockItem", stockItem1);
//        return "welcome";
//    }


}
