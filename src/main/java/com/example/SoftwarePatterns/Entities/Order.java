package com.example.SoftwarePatterns.Entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String date;
    private String status;

    @ManyToOne
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<StockItem> products = new HashSet<>();


    public Order() {
        super();
    }

    public Order(User user, String date, String status) {
        super();
        this.user = user;
        this.date = date;
        this.status = status;
    }

    public Order(User user, String date, String status, Set<StockItem> products) {
        super();
        this.user = user;
        this.date = date;
        this.status = status;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<StockItem> getProducts() {
        return products;
    }

    public void setProducts(Set<StockItem> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
