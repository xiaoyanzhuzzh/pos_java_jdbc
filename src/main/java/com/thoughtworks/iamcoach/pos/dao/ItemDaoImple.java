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
    public Item getItemById(int id) {
        Item item = null;
        String sql = "SELECT * FROM items WHERE id = '"+id+"'";
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
                    rs.getString("categoryId"));

            rs.close();
            statement.close();
            connectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

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

        String sql = "SELECT * FROM items i, items_promotions ip where i.id = ip.itemId";
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
    public void insertItem(Item item) {
        String sql = "insert into items values(null, '"+item.getBarcode()+
                "','"+item.getName()+"','"+item.getUnit()+"', "+item.getPrice()+")";
        Connection connection = connectionUtil.getConnection();
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
            connectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItemById(int id) {
        String sql = "delete from items where id = '"+id+"'";
        Connection connection = connectionUtil.getConnection();
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
            connectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(Item item) {
        String sql = "update items set barcode = '"+item.getBarcode()+"', name = '"+item.getName()
                +"',unit = '"+item.getUnit()+"' ,price = '"+item.getPrice()
                +"' where id = '"+item.getId()+"'";
        Connection connection = connectionUtil.getConnection();
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
            connectionUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
