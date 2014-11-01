package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ItemDao;
import com.thoughtworks.iamcoach.pos.dao.ItemDaoImpl;
import com.thoughtworks.iamcoach.pos.vo.Item;

import java.util.List;

public class ItemService implements ItemServiceImpl{
    ItemDaoImpl itemDao = new ItemDao();

    @Override
    public Item getItemByBarcode(String barcode) {
        return itemDao.getItemByBarcode(barcode);
    }

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }
}
