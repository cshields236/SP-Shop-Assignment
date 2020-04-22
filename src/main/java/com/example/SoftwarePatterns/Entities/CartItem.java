package com.example.SoftwarePatterns.Entities;

import javax.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private StockItem stockItem;
    private int quantity;



    public CartItem(StockItem stockItem, int quantity) {
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

    public CartItem() {
    }



}