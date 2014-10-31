package com.thoughtworks.iamcoach.pos.util;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ReadTextUtilTest {
    @Test
    public void can_get_need_text(){
        ReadTextUtil readTextUtil = new ReadTextUtil();
        String fileName = "cart.txt";
        assertThat(readTextUtil.getText(fileName).size()).isEqualTo(9);
    }
}
