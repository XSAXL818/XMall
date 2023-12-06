package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SpuAttr {
    @PrimaryKey(autoGenerate = true)
    private int spu_attr_id;
    private int spu_id;//所属spu
    private String spu_attr_name;//属性名：款式/使用季节
    private String spu_attr_value;//包头帽。。。
    private int spu_attr_image;

    public int getSpu_attr_image() {
        return spu_attr_image;
    }

    public void setSpu_attr_image(int spu_attr_image) {
        this.spu_attr_image = spu_attr_image;
    }

    public int getSpu_attr_id() {
        return spu_attr_id;
    }

    public void setSpu_attr_id(int spu_attr_id) {
        this.spu_attr_id = spu_attr_id;
    }

    public int getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(int spu_id) {
        this.spu_id = spu_id;
    }

    public String getSpu_attr_name() {
        return spu_attr_name;
    }

    public void setSpu_attr_name(String spu_attr_name) {
        this.spu_attr_name = spu_attr_name;
    }

    public String getSpu_attr_value() {
        return spu_attr_value;
    }

    public void setSpu_attr_value(String spu_attr_value) {
        this.spu_attr_value = spu_attr_value;
    }
}
