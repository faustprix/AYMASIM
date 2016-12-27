package com.aymasim.exrecise;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by faust on 12/27/16.
 */
public class Scenario3Test {


    @Test
    public void execute() throws  Exception{
        PricingRules pricingRules = new PricingRules();
        Cart cart = ShoppingCart.getCart(pricingRules);
        Product productSmall = new Product("ult_small", "Unlimited 1GB", 24.90);
        Product productMedium = new Product("ult_medium", "Unlimited 2GB", 29.90);
        Product productMedium2 = new Product("ult_medium", "Unlimited 2GB", 29.90);
        cart.add(productSmall);
        cart.add(productMedium);
        cart.add(productMedium2);
        HashMap<Product,Integer> items=cart.items();
        Double actualTotalPrice =cart.total();
        System.out.println("Items : " + items);
        System.out.println("Total Price : " + actualTotalPrice);
        Double expectedTotalPrice = 84.70;
        Assert.assertEquals(expectedTotalPrice,actualTotalPrice);
    }

}