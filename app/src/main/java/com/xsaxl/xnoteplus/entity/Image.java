package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Image {
    @PrimaryKey(autoGenerate = true)
    private int image_id;
    private int spu_id;
    private int image_url;


    @Override
    public String toString() {
        return "Image{" +
                "image_id=" + image_id +
                ", spu_id=" + spu_id +
                ", image_url=" + image_url +
                '}';
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(int spu_id) {
        this.spu_id = spu_id;
    }

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }
}
