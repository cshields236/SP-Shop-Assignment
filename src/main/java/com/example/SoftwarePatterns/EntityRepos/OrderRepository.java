package com.example.SoftwarePatterns.EntityRepos;


import com.example.SoftwarePatterns.Entities.Order;
import com.example.SoftwarePatterns.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
    Order findById(int id);
    List<Order> findByStatusAndUser(String status, User user);
    List<Order> findByUser(User user);
}
