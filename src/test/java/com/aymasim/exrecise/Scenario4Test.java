package com.aymasim.exrecise;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by faust on 12/27/16.
 */
public class Scenario4Test {

    @Test
    public void execute() throws Exception{
        PricingRules pricingRules = new PricingRules();
        Cart cart = ShoppingCart.getCart(pricingRules);
        Product productSmall = new Product("ult_small", "Unlimited 1GB", 24.90);
        Product productMedium = new Product("1gb", "1 GB Data-pack", 9.90);
        cart.add(productSmall);
        cart.add(productMedium, "I<3AMAYSIM");
        HashMap<Product,Integer> items=cart.items();
        Double actualTotalPrice =cart.total();
        System.out.println("Items : " + items);
        System.out.println("Total Price : " + actualTotalPrice);
        Double expectedTotalPrice = 31.32;
        Assert.assertEquals(expectedTotalPrice,actualTotalPrice);
    }

}