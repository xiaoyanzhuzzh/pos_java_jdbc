package com.thoughtworks.iamcoach.pos.vo;

import com.thoughtworks.iamcoach.pos.service.Scanner;

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

    public double getSubtotal() {
        List<Double> allSubTotals = new ArrayList<Double>();

        for(int i = 0; i < item.getPromotionList().size(); i++){
            System.out.println(this.getNumber());
            allSubTotals.add(item.getPromotionList().get(i).calculate(item, this.getNumber()));
        }

        return Collections.min(allSubTotals);
    }
}
