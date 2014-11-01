package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.Item;

import java.util.List;

public interface ItemService {
    Item getItemByBarcode(String barcode);
    List<Item> getItems();
}
