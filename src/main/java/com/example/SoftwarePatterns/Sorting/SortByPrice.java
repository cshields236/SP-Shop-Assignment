package com.example.SoftwarePatterns.Sorting;

import com.example.SoftwarePatterns.Entities.StockItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

 class SortByPrice implements SortingStrategy {

    @Override
    public ArrayList<StockItem> sortAsc(ArrayList<StockItem> products) {
        Collections.sort(products, new Comparator<StockItem>() {
            @Override
            public int compare(StockItem o1, StockItem o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        return products;
    }

    @Override
    public ArrayList<StockItem> sortDesc(ArrayList<StockItem> products) {
        Collections.sort(products, new Comparator<StockItem>() {
            @Override
            public int compare(StockItem o1, StockItem o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        Collections.reverse(products);


        return products;
    }
}
