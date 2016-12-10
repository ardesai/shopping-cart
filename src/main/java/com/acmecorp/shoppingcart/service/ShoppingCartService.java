package com.acmecorp.shoppingcart.service;

import com.acmecorp.shoppingcart.model.Item;

import java.util.*;
import java.text.DecimalFormat;

/**
 * Created by abhishekdesai on 10/12/2016.
 */
public class ShoppingCartService {

    private static final DecimalFormat FORMATTER = new DecimalFormat("'£'0.00");

    /**
     * Calculate total cost of supplied item.
     *
     * Following assumptions has been made:
     *
     *  1. the list of enum Items will be provided by the invoker.
     *  2. If an item is not configured for the offer then the normal price will apply.
     *
     * @param items list of items
     * @return total cost
     */
    public String getTotalCost(List<Item> items) {

        double totalPrice = 0;

        if (items == null || items.size() == 0) {
            return formatMoney(totalPrice);
        }

        for(Item item : Item.values()) {
            int itemCount = Collections.frequency(items, item);

            double itemPrice = applyOffer(item, itemCount);

            totalPrice = totalPrice + itemPrice;
        }

        return formatMoney(totalPrice);

    }

    private double applyOffer(Item item, int itemCount) {
        switch(item) {

            case Apple:
                return applyXForYOffer(2, 1, itemCount, item.getPrice());

            case Orange:
                return applyXForYOffer(3, 2, itemCount, item.getPrice());

            default:
                return itemCount * item.getPrice();

        }
    }

    private double applyXForYOffer(int x, int y, int quantity, double itemPrice) {
        int offerPriceQuantity = quantity / x;
        int reminderQuantity = quantity % x;
        double offerPrice = offerPriceQuantity * y * itemPrice;
        double reminderPrice = reminderQuantity * itemPrice;
        return offerPrice + reminderPrice;
    }

    private static String formatMoney(double price) {
        return FORMATTER.format(price);
    }
}
