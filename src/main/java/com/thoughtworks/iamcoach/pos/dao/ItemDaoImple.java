package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.ConnectionUtil;
import com.thoughtworks.iamcoach.pos.vo.*;
import org.omg.PortableInterceptor.DISCARDING;

import java.sql.*;
import java.util.*;

public class ItemDaoImple implements ItemDao {

    ConnectionUtil connectionUtil = new ConnectionUtil();
    private PromotionDao promotionDao = new PromotionDaoImple();

    @Override
    public Item getItemByBarcode(String barcode){
        Item item = null;
        Promotion promotion = null;

        String sql = "select * \n" +
                "  from items i,items_promotions ip \n" +
                " where i.id = ip.itemId and barcode='"+barcode+"'";
        Connection connection = connectionUtil.getConnection();
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
}
