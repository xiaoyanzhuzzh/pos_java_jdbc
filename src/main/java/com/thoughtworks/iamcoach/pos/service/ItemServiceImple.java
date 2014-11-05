package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.vo.*;

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

    @Override
    public List<Promotion> getPromotionsByItemId(String id) {
        return itemDao.getPromotionsByItemId(id);
    }
}
