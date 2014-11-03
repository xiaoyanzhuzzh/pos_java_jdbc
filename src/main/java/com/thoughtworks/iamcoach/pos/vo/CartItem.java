package com.thoughtworks.iamcoach.pos.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Override
    public String toString() {
        return "CartItem{" +
                "item=" + item +
                ", number=" + number +
                '}';
    }

    public double getSubtotal() {
        List<Double> allSubTotals = new ArrayList<Double>();

        for(Promotion aPromotion: item.getPromotionList()){
            CartItem cartItem = new CartItem(item, number);
            allSubTotals.add(aPromotion.calculate(cartItem, aPromotion.getDiscount()));
        }
        return Collections.min(allSubTotals);
    }
}
