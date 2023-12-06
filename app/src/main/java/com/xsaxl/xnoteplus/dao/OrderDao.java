package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.xsaxl.xnoteplus.entity.Order;

import java.util.List;

@Dao
public interface OrderDao {
    @Insert
    void insert(Order... order);
    @Delete
    void delete(Order ... order);
    @Update
    void update(Order ... order);
    @Query("SELECT * FROM `order`")
    List<Order> query();

    @Query("SELECT order_id FROM `order` WHERE user_id = :userId")
    List<Integer> queryOrderIdByUserId(int userId);

    @Query("SELECT * FROM `order` WHERE order_id = :orderId")
    Order queryOrderById(int orderId);

    @Query("SELECT MAX(order_id) FROM `order`")
    int queryMaxNumber();
}
