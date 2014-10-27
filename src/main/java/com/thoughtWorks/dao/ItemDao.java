package com.thoughtWorks.dao;

import com.thoughtworks.iamcoach.pos.Item;

import java.util.List;

public class ItemDao implements ItemDaoImpl {
    @Override
    public Item getItemById(int id) {
        Item item = new Item();
        return item;
    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public void insertItem(Item item) {

    }

    @Override
    public void deleteItemById(int id) {

    }

    @Override
    public void updateItem(Item item) {

    }
}
