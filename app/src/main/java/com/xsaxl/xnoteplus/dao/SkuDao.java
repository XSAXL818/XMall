package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.Sku;

import java.util.List;

@Dao
public interface SkuDao {
    @Insert
    void insert(Sku... sku);
    @Delete
    void delete(Sku ... sku);
    @Update
    void update(Sku ... sku);
    @Query("SELECT * FROM sku")
    List<Sku> query();


    @Query("SELECT sku_id FROM sku WHERE spu_id=:spuId AND sku_name=:颜色")
    int querySkuIdBySpuIdAndSkuName(int spuId, String 颜色);

    @Query("SELECT * FROM sku WHERE sku_id=:sku_id")
    Sku queryById(int sku_id);
}

