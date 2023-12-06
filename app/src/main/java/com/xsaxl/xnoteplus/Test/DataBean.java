package com.xsaxl.xnoteplus.Test;

import com.xsaxl.xnoteplus.R;

import java.util.ArrayList;
import java.util.List;

public class DataBean {


    public int imageUrl;

    public static List<DataBean> getTestData3() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean(R.drawable.laoshu));
        list.add(new DataBean(R.drawable.sku_attr1_1));
        list.add(new DataBean(R.drawable.sku_attr2_1));
        list.add(new DataBean(R.drawable.sku_attr3_1));
        return list;
    }

    public DataBean(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
