package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.Comment;
import com.xsaxl.xnoteplus.entity.Image;

import java.util.List;

@Dao
public interface ImageDao {
    @Insert
    void insert(Image... image);
    @Delete
    void delete(Image ... image);
    @Update
    void update(Image ... image);
    @Query("SELECT * FROM image")
    List<Image> query();

    @Query("SELECT * FROM image WHERE spu_id = :spu_id")
    List<Image> queryBySkuID(int spu_id);
}
