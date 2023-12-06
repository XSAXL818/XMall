package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class OrderDetail {
    @PrimaryKey(autoGenerate = true)
    private int order_detail_id;
    private int order_id;
    private int brand_id;
    private int spu_id;
    private String good_name;
    private int good_number;
    private double good_price;
    private int good_image;
    private int good_is_commented;
    private String good_sku;//商品的销售属性即XL码黑色

    public String getGood_sku() {
        return good_sku;
    }

    public void setGood_sku(String good_sku) {
        this.good_sku = good_sku;
    }

    public int getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(int spu_id) {
        this.spu_id = spu_id;
    }

    public int getGood_is_commented() {
        return good_is_commented;
    }

    public void setGood_is_commented(int good_is_commented) {
        this.good_is_commented = good_is_commented;
    }

    public int getGood_image() {
        return good_image;
    }


    public void setGood_image(int good_image) {
        this.good_image = good_image;
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public double getGood_price() {
        return good_price;
    }

    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }
}
