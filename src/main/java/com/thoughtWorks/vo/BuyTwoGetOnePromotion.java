package com.thoughtWorks.vo;

import com.thoughtworks.iamcoach.pos.CartItem;

public class BuyTwoGetOnePromotion extends Promotion{

    @Override
    public double caculate(CartItem cartItem, double num) {
        double promotionNumber = ((int) cartItem.getNum())/3;
        double actualNumber = cartItem.getNum() - promotionNumber;
        return actualNumber * cartItem.getPrice();
    }
}
