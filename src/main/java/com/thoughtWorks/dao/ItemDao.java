package com.thoughtWorks.dao;

import com.thoughtWorks.util.ItemConnectionUtil;
import com.thoughtworks.iamcoach.pos.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDao implements ItemDaoImpl {
    ItemConnectionUtil itemConnectionUtil = new ItemConnectionUtil();
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
        Connection connection = dbUtil.getConnection();
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
            dbUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItemById(int id) {

    }

    @Override
    public void updateItem(Item item) {

    }
}
