package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(String id);
    List<Category> getCategories();
}
