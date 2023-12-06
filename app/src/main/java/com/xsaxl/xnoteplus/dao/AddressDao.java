package com.xsaxl.xnoteplus.dao;

import android.provider.Telephony;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xsaxl.xnoteplus.entity.Address;

import java.util.List;

@Dao
public interface AddressDao {

    @Insert
    void insert(Address... address);
    @Delete
    void delete(Address... address);
    @Update
    void update(Address... address);
    @Query("SELECT * FROM address")
    List<Address> query();

    @Query("SELECT * FROM address WHERE addr_default = :addr_default")
    Address querycCityByDefault(int addr_default);
}
