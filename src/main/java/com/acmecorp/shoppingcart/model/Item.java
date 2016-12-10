package com.acmecorp.shoppingcart.model;

/**
 * Created by abhishekdesai on 10/12/2016.
 */
public enum Item {

    Apple(0.60),
    Orange(0.25);

    private double price;

    Item(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
