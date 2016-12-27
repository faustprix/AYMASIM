package com.aymasim.exrecise;

import java.util.HashMap;

/**
 * Created by faust on 12/27/16.
 */
public interface Cart {

    void add(Product product);

    void add(Product product, String promoCode);

    Double total();

    HashMap<Product,Integer> items();
}
