package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.Brand;

import java.util.List;

@Dao
public interface BrandDao {
    @Insert
    void insert(Brand... brand);
    @Delete
    void delete(Brand ... brand);
    @Update
    void update(Brand ... brand);
    @Query("SELECT * FROM brand")
    List<Brand> query();

    @Query("SELECT * FROM brand WHERE brand_id = :brand_id")
    Brand queryById(int brand_id);

    @Query("SELECT brand_id FROM brand GROUP BY brand_id")
    List<Integer> queryBrandId();
}
