package com.thoughtworks.iamcoach.pos.vo;

public abstract class Promotion {
    private String id;
    private String proDesc;
    private int type;
    private double discount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Promotion(){}

    private Promotion(String id, String proDesc, int type, double discount) {
        this.id = id;
        this.proDesc = proDesc;
        this.type = type;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id='" + id + '\'' +
                ", proDesc='" + proDesc + '\'' +
                ", type=" + type +
                ", discount=" + discount +
                '}';
    }

    public abstract double calculate(Item item, double num);


}
