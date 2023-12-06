package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.SkuAttr;
import com.xsaxl.xnoteplus.entity.SpuAttr;

import java.util.List;

@Dao
public interface SpuAttrDao {
    @Insert
    void insert(SpuAttr... spuAttr);
    @Delete
    void delete(SpuAttr ... spuAttr);
    @Update
    void update(SpuAttr ... spuAttr);
    @Query("SELECT * FROM spuAttr")
    List<SpuAttr> query();

    @Query("SELECT * FROM spuAttr WHERE spu_id = :spuId")
    List<SpuAttr> queryBySpuID(int spuId);
}
