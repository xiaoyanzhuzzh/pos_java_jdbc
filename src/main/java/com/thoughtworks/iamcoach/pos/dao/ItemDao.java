package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.ConnectionUtil;
import com.thoughtworks.iamcoach.pos.vo.Item;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao implements ItemDaoImpl {

    ConnectionUtil itemConnectionUtil = new ConnectionUtil();
    private PromotionDaoImpl promotionDao = new PromotionDao();
    @Override
    public Item getItemById(int id) {
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
    }

    @Override
    public Item getItemByBarcode(String barcode){
        Item item = null;
        String sql = "select * \n" +
                "  from items i,items_promotions ip \n" +
                " where i.id = ip.itemId and barcode='"+barcode+"'";
        Connection connection = itemConnectionUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            rs.next();
            item = new Item(rs.getString("id"),rs.getString("barcode"),rs.getString("name"),rs.getString("unit"),rs.getDouble("price"));
            String proId = rs.getString("proId");
            Promotion promotion = promotionDao.getPromotionById(proId);
            item.getPromotionList().add(promotion);
            while(rs.next()){
                proId = rs.getString("proId");
                promotion = promotionDao.getPromotionById(proId);
                item.getPromotionList().add(promotion);
            }
            rs.close();
            statement.close();
            itemConnectionUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<Item>();
        String sql = "SELECT * FROM items";
        Connection connection = itemConnectionUtil.getConnection();
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
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void insertItem(Item item) {
        String sql = "insert into items values(null, '"+item.getBarcode()+
                "','"+item.getName()+"','"+item.getUnit()+"', "+item.getPrice()+")";
        Connection connection = itemConnectionUtil.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("插入成功");
            }
            else{
                System.out.println("插入失败");
            }
            statement.close();
            itemConnectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItemById(int id) {
        String sql = "delete from items where id = '"+id+"'";
        Connection connection = itemConnectionUtil.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("删除失败");
            }
            statement.close();
            itemConnectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(Item item) {
        String sql = "update items set barcode = '"+item.getBarcode()+"', name = '"+item.getName()
                +"',unit = '"+item.getUnit()+"' ,price = '"+item.getPrice()
                +"' where id = '"+item.getId()+"'";
        Connection connection = itemConnectionUtil.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("更新成功");
            }
            else{
                System.out.println("更新失败");
            }
            statement.close();
            itemConnectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}