package com.aymasim.exrecise;

import java.util.HashMap;

/**
 * Created by faust on 12/27/16.
 */
public class CartItems {

    private HashMap<Product,Integer> items;
    private Double totalPrice;


    public HashMap<Product, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Product, Integer> items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
