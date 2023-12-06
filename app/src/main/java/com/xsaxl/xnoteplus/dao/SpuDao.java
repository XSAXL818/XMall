package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.Spu;

import java.util.List;

@Dao
public interface SpuDao {
    @Insert
    void insert(Spu... spu);
    @Delete
    void delete(Spu ... spu);
    @Update
    void update(Spu ... spu);
    @Query("SELECT * FROM spu")
    List<Spu> query();
    // @Query("SELECT * FROM tb_use WHERE Name LIKE '%' || :name" || '%')
    @Query("SELECT * FROM spu WHERE spu_name like '%' || :spu_name || '%' ")
    List<Spu> querySpuByName(String spu_name);

    @Query("SELECT * FROM spu WHERE spu_id = :spu_id")
    Spu querySpuById(int spu_id);

    @Query("SELECT spu_image FROM spu WHERE spu_id = :spu_id")
    int queryImageBySpuId(int spu_id);

    @Query("SELECT spu_name FROM spu WHERE spu_id = :spu_id")
    String queryNameBySpuId(int spu_id);

    @Query("SELECT * FROM spu WHERE spu_id = :spu_id")
    Spu queryById(int spu_id);
}
