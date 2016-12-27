package com.aymasim.exrecise;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by faust on 12/27/16.
 */
public class Scenario2Test {


    @Test
    public void execute() throws Exception {
        PricingRules pricingRules = new PricingRules();
        Cart cart = ShoppingCart.getCart(pricingRules);
        Product productSmall = new Product("ult_small", "Unlimited 1GB", 24.90);
        Product productSmall2 = new Product("ult_small", "Unlimited 1GB", 24.90);
        Product productLarge = new Product("ult_large", "Unlimited 5GB", 44.90);
        Product productLarge2 = new Product("ult_large", "Unlimited 5GB", 44.90);
        Product productLarge3 = new Product("ult_large", "Unlimited 5GB", 44.90);
        Product productLarge4 = new Product("ult_large", "Unlimited 5GB", 44.90);
        cart.add(productSmall);
        cart.add(productSmall2);
        cart.add(productLarge);
        cart.add(productLarge2);
        cart.add(productLarge3);
        cart.add(productLarge4);
        HashMap<Product,Integer> items=cart.items();
        Double actualTotalPrice =cart.total();
        System.out.println("Items : " + items);
        System.out.println("Total Price : " + actualTotalPrice);
        Double expectedTotalPrice = 209.40;
        Assert.assertEquals(expectedTotalPrice,actualTotalPrice);
    }

}