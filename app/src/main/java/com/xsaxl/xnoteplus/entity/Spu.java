package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Spu implements Comparable<Spu>{
    @PrimaryKey(autoGenerate = true)
    private int spu_id;
    private String spu_name;
    private int spu_sales;//销量
    private double spu_price;//价格
    private int brand_id;//品牌
    private int spu_image;//图片
    private int category_id;//分类
    private String spu_info;//待用
    private String spu_status;//状态
    public Spu() {
    }

    public Spu(String spu_name, double spu_price, int spu_image) {
        this.spu_name = spu_name;
        this.spu_price = spu_price;
        this.spu_image = spu_image;
    }




    public int getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(int spu_id) {
        this.spu_id = spu_id;
    }

    public String getSpu_name() {
        return spu_name;
    }

    public void setSpu_name(String spu_name) {
        this.spu_name = spu_name;
    }

    public String getSpu_info() {
        return spu_info;
    }

    public void setSpu_info(String spu_info) {
        this.spu_info = spu_info;
    }

    public String getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(String spu_status) {
        this.spu_status = spu_status;
    }

    public int getSpu_sales() {
        return spu_sales;
    }

    public void setSpu_sales(int spu_sales) {
        this.spu_sales = spu_sales;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public double getSpu_price() {
        return spu_price;
    }

    public void setSpu_price(double spu_price) {
        this.spu_price = spu_price;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getSpu_image() {
        return spu_image;
    }

    public void setSpu_image(int spu_image) {
        this.spu_image = spu_image;
    }


    @Override
    public int compareTo(Spu o) {
        return this.spu_sales - o.spu_sales;
    }
}
