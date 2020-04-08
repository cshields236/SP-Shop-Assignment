package com.example.SoftwarePatterns;

import org.springframework.data.repository.CrudRepository;


public interface StockRepository extends CrudRepository<StockItem, Integer>  {
}
