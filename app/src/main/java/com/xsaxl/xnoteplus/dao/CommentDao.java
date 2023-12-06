package com.xsaxl.xnoteplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.Cart;
import com.xsaxl.xnoteplus.entity.Comment;

import java.util.List;

@Dao
public interface CommentDao {
    @Insert
    void insert(Comment... comment);
    @Delete
    void delete(Comment ... comment);
    @Update
    void update(Comment ... comment);
    @Query("SELECT * FROM comment")
    List<Comment> query();
}
