package com.example.SoftwarePatterns.Sorting;

import com.example.SoftwarePatterns.Entities.StockItem;

import java.util.ArrayList;
import java.util.Collections;

public class SortByManufacturer implements  SortingStrategy {
    @Override
    public ArrayList<StockItem> sortAsc(ArrayList<StockItem> products) {
        Collections.sort(products, (o1, o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));



        return products;
    }

    @Override
    public ArrayList<StockItem> sortDesc(ArrayList<StockItem> products) {
        Collections.sort(products, (o1, o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));
        Collections.reverse(products);


        return products;
    }
}
