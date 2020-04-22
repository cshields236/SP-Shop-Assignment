package com.example.SoftwarePatterns.EntityRepos;

import com.example.SoftwarePatterns.Entities.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockItem, Integer> {
    StockItem findById(int id);
}
