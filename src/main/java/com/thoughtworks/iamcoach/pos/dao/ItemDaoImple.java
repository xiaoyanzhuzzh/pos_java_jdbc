package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.ConnectionUtil;
import com.thoughtworks.iamcoach.pos.vo.*;
import org.omg.PortableInterceptor.DISCARDING;

import java.sql.*;
import java.util.*;

public class ItemDaoImple implements ItemDao {

    ConnectionUtil connectionUtil = new ConnectionUtil();
    private PromotionDao promotionDao = new PromotionDaoImple();
    private PreparedStatement prepareStatement = null;
    private ResultSet rs = null;

    @Override
    public Item getItemByBarcode(String barcode){
        String sql = "SELECT * FROM items WHERE barcode = ?";

        Item item = null;
        Connection conn = connectionUtil.getConnection();
        try{
            prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setString(1, barcode);
            rs = prepareStatement.executeQuery();
            rs.next();

            item = new Item(rs.getString("id"),
                    rs.getString("barcode"),
                    rs.getString("name"),
                    rs.getString("unit"),
                    rs.getDouble("price"),
                    rs.getString("categoryId")
            );

            promotion = promotionDao.getPromotionById(rs.getString("proId"));
            if(rs.getString("proId").equals("3")){
                promotion.setDiscount(promotionDao.getDiscount());
            }
            item.getPromotionList().add(promotion);

            while(rs.next()){
                promotion = promotionDao.getPromotionById(rs.getString("proId"));
                item.getPromotionList().add(promotion);
            }
            rs.close();
            statement.close();
            connectionUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<Item>();
        List<Promotion> promotions = new ArrayList<Promotion>();

        String sql = "SELECT * FROM items ";
        Connection connection = connectionUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                items.add(new Item(
                        rs.getString("id"),
                        rs.getString("barcode"),
                        rs.getString("name"),
                        rs.getString("unit"),
                        rs.getDouble("price"),
                        rs.getString("categoryId")
                ));

            }
            rs.close();
            statement.close();
            connectionUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Promotion> getPromotionsByItemId(String id) {
        List<Promotion> promotions = new ArrayList<Promotion>();
        String sql = "SELECT promotions.*, items_promotions.discount FROM promotions, items_promotions " +
                "WHERE items_promotions.itemId=? AND promotions.id=items_promotions.proId";

        Connection connection = connectionUtil.getConnection();
        ResultSet rs = null;

        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1,id);

            rs = prepareStatement.executeQuery();
            while(rs.next()){
                Promotion promotion = PromotionFactory.getPromotionByType(rs.getInt("type"));

                promotion.setId(rs.getString("id"));
                promotion.setType(rs.getInt("type"));
                promotion.setProDesc(rs.getString("description"));
                promotion.setDiscount(rs.getDouble("discount"));

                promotions.add(promotion);
            }
            rs.close();
            prepareStatement.close();
            connectionUtil.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }
}
