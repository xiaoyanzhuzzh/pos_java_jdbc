package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.vo.Category;

import java.util.List;

public interface CategoryDaoImpl {
    Category getCategoryById(String id);
    List<Category> getItems();
}
