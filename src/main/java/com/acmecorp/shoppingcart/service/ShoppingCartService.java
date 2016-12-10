package com.acmecorp.shoppingcart.service;

import com.acmecorp.shoppingcart.model.Item;

import java.util.*;
import java.text.DecimalFormat;

import static com.acmecorp.shoppingcart.model.Item.Apple;
import static com.acmecorp.shoppingcart.model.Item.Orange;


/**
 * Created by abhishekdesai on 10/12/2016.
 */
public class ShoppingCartService {

    private static final DecimalFormat FORMATTER = new DecimalFormat("'£'0.00");

    public String getTotalCost(List<Item> items) {

        double totalPrice = 0;

        if (items == null || items.size() == 0) {
            return formatMoney(totalPrice);
        }

        for(Item item : Item.values()) {
            int itemCount = Collections.frequency(items, item);
            double itemPrice = itemCount * item.getPrice();
            totalPrice = totalPrice + itemPrice;
        }

        return formatMoney(totalPrice);

    }

    private static String formatMoney(double price) {
        return FORMATTER.format(price);
    }
}
