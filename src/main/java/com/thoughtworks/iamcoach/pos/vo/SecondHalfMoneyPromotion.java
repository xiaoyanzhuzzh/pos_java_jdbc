package com.thoughtworks.iamcoach.pos.vo;

import com.thoughtworks.iamcoach.pos.CartItem;

public class SecondHalfMoneyPromotion extends Promotion{
    @Override
    public double caculate(CartItem cartItem, double num) {
        double promotionNumber = ((int) cartItem.getNum())/2;
        double actualNumber = (cartItem.getNum() - promotionNumber) + promotionNumber/2;
        return actualNumber * cartItem.getPrice();
    }
}
