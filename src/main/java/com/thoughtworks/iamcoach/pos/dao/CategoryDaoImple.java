package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.ConnectionUtil;
import com.thoughtworks.iamcoach.pos.vo.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CategoryDaoImple implements CategoryDao {
    ConnectionUtil connectionUtil = new ConnectionUtil();

    @Override
    public Category getCategoryById(String id) {
        Category category = null;
        String sql = "SELECT * FROM categories WHERE id = '"+id+"'";
        Connection connection = connectionUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            rs.next();

            category = new Category(rs.getString("id"), rs.getString("name"));
            rs.close();
            statement.close();
            connectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getCategories() {
        return null;
    }
}
