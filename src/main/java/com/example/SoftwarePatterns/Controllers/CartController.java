package com.example.SoftwarePatterns.Controllers;

import com.example.SoftwarePatterns.Entities.CartItem;
import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.EntityRepos.StockRepository;
import com.example.SoftwarePatterns.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "cart")
public class CartController {
    @Autowired
    private StockRepository stockService;
    @Autowired
    protected OrderService orderService;

    @GetMapping(value = "index")
    public String index(HttpServletRequest request) {
        request.setAttribute("mode", "STORE_CART");

        return "welcome";
    }

    @GetMapping(value = "buy/{id}")
    public String buy(@PathVariable("id") int id, HttpSession session) {

        if (session.getAttribute("cart") == null) {
            List<CartItem> cart = new ArrayList<CartItem>();
            cart.add(new CartItem(stockService.findById(id), 1));

            session.setAttribute("cart", cart);
        } else {
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new CartItem(stockService.findById(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);

        }
        session.setAttribute("mode", "STORE_CART");
        return "welcome";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);

        session.setAttribute("cart", cart);
        session.setAttribute("mode", "STORE_CART");
        return "welcome";
    }

    private int exists(int id, List<CartItem> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getStockItem().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @PostMapping("/cart/submit")
    public String cartSubmit(Model model) {
        Set<StockItem> productsInCart = orderService.getCartContent();
        model.addAttribute("productsInCart", productsInCart);
        model.addAttribute("totalCartPrice", orderService.getTotalCartPrice());
        model.addAttribute("mode", "SUBMIT");
        return "welcome";
    }
}


