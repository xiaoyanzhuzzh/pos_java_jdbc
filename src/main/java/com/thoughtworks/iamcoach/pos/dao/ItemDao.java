package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.List;

public interface ItemDao {
        Item getItemByBarcode(String barcode);
        List<Item> getItems();
        List<Promotion> getPromotionsByItemId(String id);
}
