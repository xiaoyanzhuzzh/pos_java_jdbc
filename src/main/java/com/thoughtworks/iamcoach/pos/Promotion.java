package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private int promotionId;
    private String promotionDescribe;
    private int type;

    private List<Item> itemList = new ArrayList<Item>();  //取决于业务逻辑；
}
