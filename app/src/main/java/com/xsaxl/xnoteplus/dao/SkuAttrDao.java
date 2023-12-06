package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.SkuAttr;

import java.util.List;

@Dao
public interface SkuAttrDao {
    @Insert
    void insert(SkuAttr... skuAttr);
    @Delete
    void delete(SkuAttr ... skuAttr);
    @Update
    void update(SkuAttr ... skuAttr);
    @Query("SELECT * FROM skuAttr")
    List<SkuAttr> query();

    @Query("SELECT * FROM skuAttr WHERE sku_id=:sku_id")
    List<SkuAttr> queryBySkuAttrId(int sku_id);
}
