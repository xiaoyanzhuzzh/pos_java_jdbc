package com.thoughtworks.iamcoach.pos.vo;

public class DiscountPromotion extends Promotion{
    @Override
    public double calculate(CartItem cartItem, double discount) {
        return cartItem.getNumber() * discount * cartItem.getItem().getPrice();
    }
}
