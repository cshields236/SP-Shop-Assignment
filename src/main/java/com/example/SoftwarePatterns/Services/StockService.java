package com.example.SoftwarePatterns.Services;

import com.example.SoftwarePatterns.Entities.StockItem;
import com.example.SoftwarePatterns.EntityRepos.StockRepository;
import com.example.SoftwarePatterns.Iterator.Container;
import com.example.SoftwarePatterns.Iterator.Iterator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StockService implements Container {
    List<StockItem> stockItems;
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void saveStock(StockItem stockItem) {
        stockRepository.save(stockItem);
    }

    public List<StockItem> showAllStock() {
        stockItems = new ArrayList<StockItem>();
        for (StockItem stockItem : stockRepository.findAll()) {
            stockItems.add(stockItem);
        }

        return stockItems;
    }


    public StockItem findById(int id) {
        return stockRepository.findById(id);
    }

    @Override
    public Iterator getIterator() {
        return new StockIterator();
    }


    private class StockIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < stockItems.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return stockItems.get(index++);
            }
            return null;
        }
    }
}
