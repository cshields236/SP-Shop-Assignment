package com.example.SoftwarePatterns.SortingStrategy;

import com.example.SoftwarePatterns.Entities.StockItem;

import java.util.ArrayList;

public interface SortingStrategy {

    public ArrayList<StockItem> sortAsc(ArrayList<StockItem> products);
    public ArrayList<StockItem> sortDesc(ArrayList<StockItem> products);


}