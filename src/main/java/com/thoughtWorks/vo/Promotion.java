package com.thoughtWorks.vo;

abstract class Promotion {
    private String id;
    private String proDesc;
    private int type;

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

    public Promotion(){}

    private Promotion(String id, String proDesc, int type) {
        this.id = id;
        this.proDesc = proDesc;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id='" + id + '\'' +
                ", proDesc='" + proDesc + '\'' +
                ", type=" + type +
                '}';
    }

    public abstract double caculate(Item item, double num);
}
