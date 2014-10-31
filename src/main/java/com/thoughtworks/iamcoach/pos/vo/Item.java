package com.thoughtworks.iamcoach.pos.vo;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private String id;
    private String barcode;
    private String name;
    private String unit;
    private double price;

    private List<Promotion> promotionList = new ArrayList<Promotion>();

    public Item(){

    }

    public Item(String id, String barcode, String name, String unit, double price){
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public Item(String id, String barcode, String name, double price, String unit, List<Promotion> promotionList) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.promotionList = promotionList;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    public String getUnit(){
        return this.unit;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }

    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }
    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }

}
