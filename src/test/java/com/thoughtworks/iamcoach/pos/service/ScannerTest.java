package com.thoughtworks.iamcoach.pos.service;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ScannerTest {
    @Test
    public void can_get_inputs_test(){
        Scanner scanner = new Scanner();
        assertThat(scanner.getInputs().size()).isEqualTo(9);
        assertThat(scanner.getInputs().get(0)).isEqualTo("ITEM000001");
    }

}
