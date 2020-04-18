package com.example.SoftwarePatterns.Controllers;

import com.example.SoftwarePatterns.Entities.Item;
import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.EntityRepos.StockRepository;
import com.example.SoftwarePatterns.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "cart")
public class CartController {
    @Autowired
    private StockRepository stockService;

    @GetMapping(value = "index")
    public String index(HttpServletRequest request) {
        request.setAttribute("mode", "STORE_CART");

        return "welcome";
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") int id, HttpServletRequest request) {

        if (request.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(stockService.findById(id), 1));
            request.setAttribute("mode", "STORE_CART");
            request.setAttribute("cart", cart);
        } else {
            List<Item> cart = (List<Item>) request.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Item(stockService.findById(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }

            request.setAttribute("cart", cart);
            request.setAttribute("mode", "STORE_CART");
        }
        return "welcome";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, HttpServletRequest request) {
        List<Item> cart = (List<Item>) request.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);

        request.setAttribute("cart", cart);
        request.setAttribute("mode", "STORE_CART");
        return "welcome";
    }

    private int exists(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getStockItem().getId() == id) {
                return i;
            }
        }
        return -1;
    }
}


