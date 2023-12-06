package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.Order;
import com.xsaxl.xnoteplus.entity.OrderDetail;

import java.util.List;

@Dao
public interface OrderDetailDao {
    @Insert
    void insert(OrderDetail... orderDetail);
    @Delete
    void delete(OrderDetail ... orderDetail);
    @Update
    void update(OrderDetail ... orderDetail);
    @Query("SELECT * FROM orderDetail")
    List<OrderDetail> query();


    @Query("SELECT * FROM orderDetail WHERE order_id = :order_id")
    List<OrderDetail> queryByOrderId(int order_id);
}
