package com.example.SoftwarePatterns.Entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    public Role() {

    }
    public Role(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}