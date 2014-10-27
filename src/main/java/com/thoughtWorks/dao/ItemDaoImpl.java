package com.thoughtWorks.dao;

import com.thoughtworks.iamcoach.pos.Item;

import java.util.List;

public interface ItemDaoImpl {
        Item getItemById(int id);
        List<Item> getItems();
        void insertItem(Item item);
        void deleteItemById(int id);
        void updateItem(Item item);
}
