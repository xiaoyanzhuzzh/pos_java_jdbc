package com.thoughtworks.iamcoach.pos.vo;

public class BuyTwoGetOnePromotion extends Promotion{

    @Override
    public double calculate(Item item, double number) {
        double promotionNumber = ((int) number)/3;
        double actualNumber = number - promotionNumber;
        return actualNumber * item.getPrice();
    }
}
