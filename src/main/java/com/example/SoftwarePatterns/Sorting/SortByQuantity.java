package com.example.SoftwarePatterns.Sorting;

import com.example.SoftwarePatterns.Entities.StockItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByQuantity implements SortingStrategy {
    @Override
    public ArrayList<StockItem> sortAsc(ArrayList<StockItem> products) {
        Collections.sort(products, new Comparator<StockItem>() {
            @Override
            public int compare(StockItem o1, StockItem o2) {
              return   o1.getQuantity() - o2.getQuantity();
            }
        });
        return products;
        }

    @Override
    public ArrayList<StockItem> sortDesc(ArrayList<StockItem> products) {
        Collections.sort(products, new Comparator<StockItem>() {
            @Override
            public int compare(StockItem o1, StockItem o2) {
                return   o1.getQuantity() - o2.getQuantity();
            }
        });
       Collections.reverse(products);
       return products;
    }
}
