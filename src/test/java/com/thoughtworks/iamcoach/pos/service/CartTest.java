package com.thoughtworks.iamcoach.pos.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class CartTest {
    @Test
    public void can_get_CartItems_test(){
        Cart cart = new Cart();
        assertThat(cart.getCartItems().size()).isEqualTo(0);
    }

    @Test
    public void can_get_numbers_test(){
        Cart cart = new Cart();
        List<String> input = new ArrayList<String>();
        assertThat(cart.getNumber(input).size()).isEqualTo(0);
    }
}
