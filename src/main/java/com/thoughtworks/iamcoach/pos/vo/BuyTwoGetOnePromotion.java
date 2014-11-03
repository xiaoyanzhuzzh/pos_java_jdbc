package com.thoughtworks.iamcoach.pos.vo;

public class BuyTwoGetOnePromotion extends Promotion{

    @Override
    public double calculate(CartItem cartItem, double discount) {
        double promotionNumber = ((int) cartItem.getNumber())/3;
        double actualNumber = cartItem.getNumber() - promotionNumber;
        return actualNumber * cartItem.getItem().getPrice();
    }
}
