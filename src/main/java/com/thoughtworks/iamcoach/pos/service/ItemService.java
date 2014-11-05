package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.*;

import java.util.List;

public interface ItemService {
    Item getItemByBarcode(String barcode);
    List<Item> getItems();
    List<Promotion> getPromotionsByItemId(String id);
}
