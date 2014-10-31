package com.thoughtworks.iamcoach.pos.vo;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CategoryTest {
    @Test

    public void can_get_arguments_value() {
        Category category = new Category(null, "水果");
        assertThat(category.getName()).isEqualTo("橙汁");
        assertThat(category.getId()).isEqualTo(null);
    }

}
