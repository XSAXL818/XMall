package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SkuAttr {
    @PrimaryKey(autoGenerate = true)
    private int sku_attr_id;
    private int sku_id;
    private int category_id;
    private String sku_attr_name;
    private int sku_attr_image;

    @Override
    public String toString() {
        return "SkuAttr{" +
                "sku_attr_id=" + sku_attr_id +
                ", sku_id=" + sku_id +
                ", category_id=" + category_id +
                ", sku_attr_name='" + sku_attr_name + '\'' +
                ", sku_attr_image=" + sku_attr_image +
                '}';
    }

    public int getSku_attr_id() {
        return sku_attr_id;
    }

    public void setSku_attr_id(int sku_attr_id) {
        this.sku_attr_id = sku_attr_id;
    }

    public int getSku_id() {
        return sku_id;
    }

    public void setSku_id(int sku_id) {
        this.sku_id = sku_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getSku_attr_name() {
        return sku_attr_name;
    }

    public void setSku_attr_name(String sku_attr_name) {
        this.sku_attr_name = sku_attr_name;
    }

    public int getSku_attr_image() {
        return sku_attr_image;
    }

    public void setSku_attr_image(int sku_attr_image) {
        this.sku_attr_image = sku_attr_image;
    }
}
