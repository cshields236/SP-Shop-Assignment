package com.example.SoftwarePatterns.Entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StockItem {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Integer id;
    String title, manufacturer, category, image;
    int quantity;
    double price;

    @ManyToMany
    private Set<Order> orders = new HashSet<>();

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public StockItem() {
    }

    public StockItem(String title, String manufacturer, String category, String image, double price, int quantity) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.category = category;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}