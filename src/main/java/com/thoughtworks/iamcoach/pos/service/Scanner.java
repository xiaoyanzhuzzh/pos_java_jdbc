package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.util.ReadTextUtil;

import java.util.List;

public class Scanner {
    public List<String> getInputs() {
        ReadTextUtil readTextUtil = new ReadTextUtil();
        return readTextUtil.getText("cart.txt");
    }
}
