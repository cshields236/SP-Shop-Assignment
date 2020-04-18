package com.example.SoftwarePatterns.Entities;

public class Item {



    private StockItem stockItem;
    private int quantity;



    public Item(StockItem stockItem, int quantity) {
        this.stockItem = stockItem;
        this.quantity = quantity;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item() {
    }



}