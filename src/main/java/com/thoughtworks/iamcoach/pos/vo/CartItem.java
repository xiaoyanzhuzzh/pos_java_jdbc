package com.thoughtworks.iamcoach.pos.vo;

public class CartItem {
    private Item item;
    private double number;

    public Item getItem() {
        return this.item;
    }

    public double getNumber() {
        return this.number;
    }

    public CartItem(Item item, double number) {
        this.item = item;
        this.number = number;
    }

}
