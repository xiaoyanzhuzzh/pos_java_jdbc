package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemTest {
    @Test

    public void can_get_arguments_value() {
        Item item = new Item(null,"ITEM000001", "橙汁", "瓶", 5.00);
        assertThat(item.getName()).isEqualTo("橙汁");
        assertThat(item.getBarcode()).isEqualTo("ITEM000001");
        assertThat(item.getUnit()).isEqualTo("瓶");
        assertThat(item.getPrice()).isEqualTo(5.00);
        assertThat(item.getPromotion().get(0)).isEqualTo("buy_two_get_one_free_promotion");
    }

}
