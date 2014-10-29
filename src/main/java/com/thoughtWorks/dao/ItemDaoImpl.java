package com.thoughtWorks.dao;


import com.thoughtWorks.vo.Item;

import java.util.List;

public interface ItemDaoImpl {
        Item getItemById(int id);
        Item getItemByBarcode(String barcode);
        List<Item> getItems();
        void insertItem(Item item);
        void deleteItemById(int id);
        void updateItem(Item item);
}
