package com.xsaxl.xnoteplus;

import java.util.List;

// 店铺和选中的商品的信息,用于购物车和订单
public class Store {
    private int brand_id;
    private String brand_name;
    private List<Good> goods;
    private boolean ischeck;

    public Store() {

    }

    public boolean isIscheck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }

    public Store(int brand_id, String brand_name, List<Good> goods) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.goods = goods;
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

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }
}
