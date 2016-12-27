package com.aymasim.exrecise;

import java.util.HashMap;

/**
 * Created by faust on 12/27/16.
 */
public class ShoppingCart implements Cart {

    private static ShoppingCart cart = new ShoppingCart();
    private static HashMap<Product,Integer> products= new HashMap<Product, Integer>();

    private static PricingRules pricingRules;
    private static String promoCode;

    public static ShoppingCart getCart(PricingRules pricingRules)
    {
        ShoppingCart.pricingRules = pricingRules;
        return cart;
    }

    public void add(Product product) {
        if(products.get(product)==null){
            products.put(product,1);
        } else{
            int noOfProducts = products.get(product);
            noOfProducts+=1;
            products.put(product,noOfProducts);
        }
    }

    public void add(Product product, String promoCode) {
        this.add(product);
        ShoppingCart.promoCode = promoCode;
    }

    public Double total() {
        return pricingRules.execute(products, promoCode).getTotalPrice();
    }

    public HashMap<Product,Integer> items() {
        CartItems cartItems=pricingRules.execute(products, promoCode);
        HashMap<Product,Integer> items = cartItems.getItems();
        return items;
    }
}
