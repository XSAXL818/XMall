package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cart {

    @PrimaryKey(autoGenerate = true)
    private int cart_id;
    private int user_id;//用户id
    private int spu_id;//商品id
    private int brand_id;//品牌
    private int good_number;// 数量
    private String good_name;// 名称
    private int good_url;//图片
    private double good_price;//价格

    private String good_sku;//XL码黑色

    public String getGood_sku() {
        return good_sku;
    }

    public void setGood_sku(String good_sku) {
        this.good_sku = good_sku;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", user_id=" + user_id +
                ", spu_id=" + spu_id +
                ", brand_id=" + brand_id +
                ", good_number=" + good_number +
                ", good_name='" + good_name + '\'' +
                ", good_url=" + good_url +
                ", good_price=" + good_price +
                ", good_sku='" + good_sku + '\'' +
                '}';
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(int spu_id) {
        this.spu_id = spu_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getGood_number() {
        return good_number;
    }

    public void setGood_number(int good_number) {
        this.good_number = good_number;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public int getGood_url() {
        return good_url;
    }

    public void setGood_url(int good_url) {
        this.good_url = good_url;
    }

    public double getGood_price() {
        return good_price;
    }

    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }
}
