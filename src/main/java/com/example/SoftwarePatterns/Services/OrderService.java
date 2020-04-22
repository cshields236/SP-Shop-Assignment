package com.example.SoftwarePatterns.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.SoftwarePatterns.Entities.Order;
import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.Entities.User;
import com.example.SoftwarePatterns.EntityRepos.OrderRepository;
import com.example.SoftwarePatterns.EntityRepos.StockRepository;
import com.example.SoftwarePatterns.EntityRepos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
public class OrderService
{
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Autowired
    protected UserRepository usersRepository;

    @Autowired
    protected OrderRepository ordersRepository;

    @Autowired
    protected StockRepository productsRepository;


    private User getAuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return usersRepository.findByUsername(username);
    }

    public List<Order> getOrders() {
        return ordersRepository.findByUser(getAuthUser());
    }

    public String getOrderTotalCost(int orderId) {
        Order order = ordersRepository.findById(orderId);
        if (order != null) {
            int totalCost = 0;
            for (StockItem product: order.getProducts()) {
                double price = product.getPrice();
                totalCost += price;
            }
            return Integer.toString(totalCost);
        }

        return "";
    }

    public Order addNewCart() {
        User user = getAuthUser();
        Date date = new Date();
        Order cart = new Order(user, sdf.format(date), "cart");
        ordersRepository.save(cart);
        return cart;
    }

    public Order getCart() {
        User user = getAuthUser();
        List<Order> orders = ordersRepository.findByStatusAndUser("cart", user);
        if (orders.size() > 0) {
            Order cart = orders.get(0);
            return cart;
        }

        return addNewCart();
    }

    public void addToCart(int productId) {
        Optional<StockItem> queryResult = Optional.ofNullable(productsRepository.findById(productId));
        if (queryResult.isPresent()) {
            StockItem product = queryResult.get();
            Order cart = getCart();
            Set<StockItem> productsInCart = cart.getProducts();
            Boolean alreadyInCart = false;
            for (StockItem item: productsInCart ) {
                if (item.getId() == productId) {
                    alreadyInCart = true;
                }
            }
            if (!alreadyInCart) {
                productsInCart.add(product);
                product.getOrders().add(cart);
                ordersRepository.save(cart);
                productsRepository.save(product);
            }
        }
    }

    public void removeFromCart(int productId) {
        Optional<StockItem> queryResult = Optional.ofNullable(productsRepository.findById(productId));
        if (queryResult.isPresent()) {
            StockItem product = queryResult.get();
            Order cart = getCart();
            product.getOrders().removeIf(order -> order.getId() == cart.getId());
            cart.getProducts().removeIf(prod -> prod.getId() == productId);
            ordersRepository.save(cart);
            productsRepository.save(product);
        }
    }

    public Set<StockItem> getCartContent() {
        Order cart = getCart();
        Set<StockItem> productsInCart = cart.getProducts();
        return productsInCart;
    }

    public int getCartSize() {
        return getCartContent().size();
    }

    public String getTotalCartPrice() {
        Set<StockItem> productsInCart = getCartContent();
        int totalPrice = 0;
        for (StockItem product: productsInCart) {
            double price = product.getPrice();
            totalPrice += price;
        }
        return Integer.toString(totalPrice);
    }

    public void clearCartContent() {
        Order cart = getCart();
        Set<StockItem> productsInCart = cart.getProducts();
        for (StockItem product: productsInCart) {
            product.getOrders().removeIf(order -> order.getId() == cart.getId());
            productsRepository.save(product);
        }
        cart.getProducts().clear();
        ordersRepository.save(cart);
    }

    public void cartToOrder() {
        User user = getAuthUser();
        List<Order> orders  = ordersRepository.findByStatusAndUser("cart", user);
        if (orders.size() > 0) {
            Order cart = orders.get(0);
            cart.setStatus("ordered");
            ordersRepository.save(cart);
        }
    }
}

