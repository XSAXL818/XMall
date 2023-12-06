package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.Cart;

import java.util.List;

@Dao
public interface CartDao {
    @Insert
    void insert(Cart... cart);
    @Delete
    void delete(Cart ... cart);
    @Update
    void update(Cart ... cart);
    @Query("SELECT * FROM cart")
    List<Cart> query();

    @Query("SELECT * FROM cart WHERE brand_id = :brand_id")
    List<Cart> queryByBrandId( int brand_id);

    @Query("SELECT brand_id FROM cart WHERE user_id = :user_id GROUP BY brand_id")
    List<Integer> queryBrandIdByUserId(int user_id);
}
