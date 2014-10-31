package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PromotionDao implements PromotionDaoImpl{
    @Override
    public Promotion getPromotionById(String id) {
        Item item = null;
        String sql = "SELECT * FROM items WHERE id = '"+id+"'";
        Connection connection = itemConnectionUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            rs.next();

            item = new Item(rs.getString("id"),
                    rs.getString("barcode"),
                    rs.getString("name"),
                    rs.getString("unit"),
                    rs.getDouble("price")
            );

            rs.close();
            statement.close();
            itemConnectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
        return null;
    }

    @Override
    public List<Promotion> getPromotions() {
        return null;
    }

    @Override
    public void insertPromotion(Promotion promotion) {

    }

    @Override
    public void deletePromotionById(int id) {

    }

    @Override
    public void updatePromtion(Promotion promotion) {

    }
}
