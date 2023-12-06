package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Brand {
    @PrimaryKey(autoGenerate = true)
    private int brand_id;
    private String brand_name;
    private String brand_info;
    private int brand_logo;

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id=" + brand_id +
                ", brand_name='" + brand_name + '\'' +
                ", brand_info='" + brand_info + '\'' +
                ", brand_logo=" + brand_logo +
                '}';
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_info() {
        return brand_info;
    }

    public void setBrand_info(String brand_info) {
        this.brand_info = brand_info;
    }

    public int getBrand_logo() {
        return brand_logo;
    }

    public void setBrand_logo(int brand_logo) {
        this.brand_logo = brand_logo;
    }
}
