package com.thoughtworks.iamcoach.pos;

import java.io.*;
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

    private ArrayList<String> promotion = new ArrayList<String>();
    private ArrayList<String> promotionText = new ArrayList<String>();

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

    public ArrayList<String> getPromotion(){
        return this.promotion;
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

    private void generatePromotions() {
        ArrayList<Path> promotionLocations = new ArrayList<Path>();
        promotionLocations.add(FileSystems.getDefault().getPath("src/main/resources/", "buy_two_get_one_free_promotion.txt"));
        promotionLocations.add(FileSystems.getDefault().getPath("src/main/resources/", "second_half_price_promotion.txt"));
        promotionLocations.add(FileSystems.getDefault().getPath("src/main/resources/", "discount_promotion.txt"));

        for (int i = 0; i < promotionLocations.size(); i++) {
            generateOnePromotion(promotionLocations, i);
        }
    }
    
    private void generateOnePromotion(ArrayList<Path> promotionLocations, int i) {
        ArrayList<String> promotionNames = new ArrayList<String>();
        promotionNames.add("buy_two_get_one_free_promotion");
        promotionNames.add("second_half_price_promotion");
        promotionNames.add("discount_promotion");

        try {
            promotionText = (ArrayList<String>) Files.readAllLines(promotionLocations.get(i));

            ArrayList<String> barcodes = splitPromotionText();
            boolean isExist = barcodes.contains(barcode);
            if (isExist) {
                promotion.add(promotionNames.get(i));
            }
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }
    }

    private ArrayList<String> splitPromotionText(){
        ArrayList<String> barcodes = new ArrayList<String>();

        for(String aPromotionText: promotionText){
            String[] barcodeAndDiscount = aPromotionText.split(":");
            barcodes.add(barcodeAndDiscount[0]);
        }
        return barcodes;
    }
}
