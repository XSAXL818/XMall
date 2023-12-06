package com.xsaxl.xnoteplus.Util;

import java.io.Serializable;
import java.util.List;

public class MyList implements Serializable {


    private static final long serialVersionUID = -7620435178023928252L;
    private int brand_id;
    private List<Integer> sku_ids;

    public MyList() {

    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public List<Integer> getSku_ids() {
        return sku_ids;
    }

    public void setSku_ids(List<Integer> sku_ids) {
        this.sku_ids = sku_ids;
    }

    public MyList(int brand_id, List<Integer> sku_ids) {
        this.brand_id = brand_id;
        this.sku_ids = sku_ids;
    }
}
