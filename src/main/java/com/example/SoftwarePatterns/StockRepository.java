package com.example.SoftwarePatterns;

import com.example.SoftwarePatterns.Entities.StockItem;
import org.springframework.data.repository.CrudRepository;


public interface StockRepository extends CrudRepository<StockItem, Integer>  {
}
