package com.example.SoftwarePatterns.Entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name, username, password, address, payment;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Role> roles;
    public User() {
    }


    public User(String name, String username, String password, String address, String payment) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.payment = payment;
    }
    public User(String name, String username, String password, String address, String payment, List<Role> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.payment = payment;
        this.roles = roles;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
