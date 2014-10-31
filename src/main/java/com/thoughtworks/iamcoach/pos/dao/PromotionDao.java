package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.ConnectionUtil;
import com.thoughtworks.iamcoach.pos.vo.*;

import java.sql.*;
import java.util.List;

import static com.thoughtworks.iamcoach.pos.vo.PromotionFactory.getPromotionByType;

public class PromotionDao implements PromotionDaoImpl{
    ConnectionUtil connectionUtil = new ConnectionUtil();

    @Override
    public Promotion getPromotionById(String id) {
        Promotion promotion = null;
        String sql = "SELECT * FROM promotions WHERE id = '"+id+"'";
        Connection connection = connectionUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            rs.next();

            promotion = getPromotionByType(rs.getInt("type"));
            promotion.setId(rs.getString("id"));
            promotion.setProDesc(rs.getString("proDesc"));
            promotion.setType(rs.getInt("type"));

            rs.close();
            statement.close();
            connectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return promotion;
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
