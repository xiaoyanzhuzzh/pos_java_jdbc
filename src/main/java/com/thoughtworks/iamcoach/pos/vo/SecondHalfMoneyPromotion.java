package com.thoughtworks.iamcoach.pos.vo;

public class SecondHalfMoneyPromotion extends Promotion{
    @Override
    public double calculate(Item item, double number) {
        double promotionNumber = ((int) number)/2;
        double actualNumber = (number - promotionNumber) + promotionNumber/2;
        return actualNumber * item.getPrice();
    }
}
