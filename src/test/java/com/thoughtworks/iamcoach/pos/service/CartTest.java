package com.thoughtworks.iamcoach.pos.service;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class CartTest {
    Scanner scanner;
    ItemService itemServiceImple;
    @Before
    public void before(){
        scanner = mock(Scanner.class);
        itemServiceImple = mock(ItemServiceImple.class);
    }

    @Test
    public void can_get_CartItems_test(){
        Scanner scanner = new Scanner();
        ItemService itemServiceImple = new ItemServiceImple();
        Cart cart = new Cart(scanner, itemServiceImple);
        assertThat(cart.getCartItems().size()).isEqualTo(3);
    }

}
