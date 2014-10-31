package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.Item;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartItemTest {
    @Test
    public void can_get_arguments_value() {

        Item item = mock(Item.class);
        when(item.getId()).thenReturn("1");
        when(item.getName()).thenReturn("橙汁");
        when(item.getBarcode()).thenReturn("ITEM000001");
        when(item.getPrice()).thenReturn(5.00);
        when(item.getUnit()).thenReturn("瓶");

        double number = 4.0;
        CartItem cartItem = new CartItem(item, number);

        assertThat(cartItem.getNumber()).isEqualTo(4.0);
        assertThat(cartItem.getName()).isEqualTo("橙汁");
        assertThat(cartItem.getBarcode()).isEqualTo("ITEM000001");
        assertThat(cartItem.getUnit()).isEqualTo("瓶");
        assertThat(cartItem.getPrice()).isEqualTo(5.00);
    }
    @Test
//    public void can_get_subTotal() {
//        Item item = mock(Item.class);
//        when(item.getName()).thenReturn("橙汁");
//        when(item.getBarcode()).thenReturn("ITEM000001");
//        when(item.getPrice()).thenReturn(5.00);
//        when(item.getUnit()).thenReturn("瓶");
//
//        double number = 4.00;
//        CartItem cartItem = new CartItem(item, number);
//
//        PromotionCalculator promotionCalculator = mock(PromotionCalculator.class);
//        when(promotionCalculator.caLculateBuyTwoGetOneFreePromotion(cartItem)).thenReturn(20.00);
//        when(promotionCalculator.caLculateSecondHalfPricePromotion(cartItem)).thenReturn(15.00);
//        when(promotionCalculator.caLculateDiscountPromotion(cartItem)).thenReturn(23.00);
//
//        assertThat(cartItem.getSubTotal()).isEqualTo(15.00);
//    }
}