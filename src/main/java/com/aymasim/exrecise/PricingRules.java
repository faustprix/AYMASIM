package com.aymasim.exrecise;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faust on 12/27/16.
 */
public class PricingRules {

    private static final String PROMO_CODE="I<3AMAYSIM";
    private static DecimalFormat decimalFormat = new DecimalFormat(".##");
    private boolean hasBundled;

    public CartItems execute(HashMap<Product, Integer> products, String promoCode) {
        CartItems items = new CartItems();
        Double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getCode().equalsIgnoreCase("ult_small") && entry.getValue() == 3) {
                Double price = entry.getKey().getPrice();
                totalPrice += price * 2;
            } else if (entry.getKey().getCode().equalsIgnoreCase("ult_large") && entry.getValue() > 3) {
                totalPrice += entry.getValue() * 39.90;
            } else if (entry.getKey().getCode().equalsIgnoreCase("ult_medium")) {
                totalPrice += entry.getValue() * entry.getKey().getPrice();
                // add data pack as bundled product
               hasBundled=true;
            } else {
                totalPrice += entry.getKey().getPrice() * entry.getValue();
            }
        }

        if (promoCode != null && promoCode.equalsIgnoreCase(PROMO_CODE)) {
            totalPrice = totalPrice - (totalPrice * 0.10);
        }
        if(hasBundled){
             Product bundled = new Product("1gb", "1 GB Data-pack", 0.0);
            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                if (entry.getKey().getCode().equalsIgnoreCase("ult_medium")) {
                    products.put(bundled,entry.getValue());
                    break;
                }
            }
        }
        items.setItems(products);
        items.setTotalPrice(Double.valueOf(decimalFormat.format(totalPrice)));
        return items;
    }
}
