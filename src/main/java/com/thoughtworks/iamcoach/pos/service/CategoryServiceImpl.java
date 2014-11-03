package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.dao.CategoryDaoImple;
import com.thoughtworks.iamcoach.pos.vo.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private CategoryDao categoryDaoImple = new CategoryDaoImple();

    @Override
    public Category getCategoryById(String id) {
        return categoryDaoImple.getCategoryById(id);
    }

    @Override
    public List<Category> getCategories() {
        return categoryDaoImple.getCategories();
    }
}
