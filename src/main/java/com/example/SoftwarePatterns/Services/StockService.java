package com.example.SoftwarePatterns.Services;

import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.EntityRepos.StockRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void saveStock(StockItem stockItem ) {
        stockRepository.save(stockItem);
    }

    public List<StockItem> showAllStock(){
        List<StockItem> stockItems = new ArrayList<StockItem>();
        for(StockItem stockItem : stockRepository.findAll()) {
            stockItems.add(stockItem);
        }

        return stockItems;
    }




    public StockItem findById(int id) {
        return stockRepository.findById(id);
    }
}