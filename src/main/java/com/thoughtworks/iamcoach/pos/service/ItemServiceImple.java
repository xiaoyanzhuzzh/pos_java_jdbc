package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.vo.Item;

import java.util.List;

public class ItemServiceImple implements ItemService {
    ItemDao itemDao = new ItemDaoImple();

    @Override
    public Item getItemByBarcode(String barcode) {
        return itemDao.getItemByBarcode(barcode);
    }

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }
}
