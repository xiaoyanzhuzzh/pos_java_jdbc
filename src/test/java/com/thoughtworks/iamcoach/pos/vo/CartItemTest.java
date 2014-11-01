package com.thoughtworks.iamcoach.pos.vo;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CartItemTest {
    @Test
    public void can_get_values_test(){
        Item item = new Item(null, "ITEM000002", "橙汁", "瓶", 5.0, "2");
        double number = 5.0;
        CartItem cartItem = new CartItem(item, number);
        assertThat(cartItem.getItem().getBarcode()).isEqualTo("ITEM000002");
        assertThat(cartItem.getItem().getUnit()).isEqualTo("瓶");
        assertThat(cartItem.getItem().getName()).isEqualTo("chengz");
        assertThat(cartItem.getNumber()).isEqualTo(5.0);
    }

}
