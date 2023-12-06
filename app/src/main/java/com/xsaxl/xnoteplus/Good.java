package com.xsaxl.xnoteplus;

public class Good {
    private int spu_id;
    private int user_id;
    private String good_name;
    private int good_number;
    private int good_image;
    private String good_sku;
    private double good_price;
    private boolean ischeck;


    public Good(String good_name, int good_image, String good_sku, double good_price) {
        this.good_name = good_name;
        this.good_image = good_image;
        this.good_sku = good_sku;
        this.good_price = good_price;
    }

    public Good(String good_name, int good_number, int good_image, String good_sku, double good_price) {
        this.good_name = good_name;
        this.good_number = good_number;
        this.good_image = good_image;
        this.good_sku = good_sku;
        this.good_price = good_price;
    }

    public Good() {

    }

    public boolean isIscheck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }

    public double getGood_price() {
        return good_price;
    }

    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }

    public int getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(int spu_id) {
        this.spu_id = spu_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public int getGood_number() {
        return good_number;
    }

    public void setGood_number(int good_number) {
        this.good_number = good_number;
    }

    public int getGood_image() {
        return good_image;
    }

    public void setGood_image(int good_image) {
        this.good_image = good_image;
    }

    public String getGood_sku() {
        return good_sku;
    }

    public void setGood_sku(String good_sku) {
        this.good_sku = good_sku;
    }
}
