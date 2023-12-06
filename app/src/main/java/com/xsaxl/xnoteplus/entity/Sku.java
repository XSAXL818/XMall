package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sku {
    @PrimaryKey(autoGenerate = true)
    private int sku_id;
    private int spu_id;
    private String sku_name;




    @Override
    public String toString() {
        return "Sku{" +
                "sku_id=" + sku_id +
                ", spu_id=" + spu_id +
                ", sku_name='" + sku_name + '\'' +
                '}';
    }

    public int getSku_id() {
        return sku_id;
    }

    public void setSku_id(int sku_id) {
        this.sku_id = sku_id;
    }

    public int getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(int spu_id) {
        this.spu_id = spu_id;
    }

    public String getSku_name() {
        return sku_name;
    }

    public void setSku_name(String sku_name) {
        this.sku_name = sku_name;
    }
}
