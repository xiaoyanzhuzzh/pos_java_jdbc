package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.Item;

public class CartItem extends Item{
    private double number;

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public CartItem(){

    }

    public CartItem(Item item, double number) {
        super(item.getId(), item.getBarcode(), item.getName(), item.getUnit(), item.getPrice(), item.getCategoryId());
        this.number = number;
    }
}
