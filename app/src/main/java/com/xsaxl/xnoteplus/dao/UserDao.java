package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User... user);

    @Delete
    void delete(User... user);

    @Update
    void update(User... user);

    @Query("SELECT * FROM user WHERE user_acc = :user_acc")
    User queryUserByAcc(String user_acc);

    @Query("SELECT * FROM user ")
    List<User> query();

    @Query("SELECT * FROM user WHERE user_id = :user_id ")
    User queryUserById(int user_id);



}
