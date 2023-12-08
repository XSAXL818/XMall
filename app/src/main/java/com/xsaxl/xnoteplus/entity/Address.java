package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Address implements Comparable<Address> {
    @PrimaryKey(autoGenerate = true)
    private int addr_id;
    private int user_id;
    private String addr_name;//收货人姓名
    private String addr_city;//城市/详细地址
    private String addr_region;//地区/省/市/区/..
    private String addr_phone;// 收获手机号
    private int addr_default;// 是否默认

    public String getAddr_name() {
        return addr_name;
    }

    public void setAddr_name(String addr_name) {
        this.addr_name = addr_name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addr_id=" + addr_id +
                ", user_id=" + user_id +
                ", addr_city='" + addr_city + '\'' +
                ", addr_region='" + addr_region + '\'' +
                ", addr_phone='" + addr_phone + '\'' +
                ", addr_default=" + addr_default +
                '}';
    }

    public int getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(int addr_id) {
        this.addr_id = addr_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAddr_city() {
        return addr_city;
    }

    public void setAddr_city(String addr_city) {
        this.addr_city = addr_city;
    }

    public String getAddr_region() {
        return addr_region;
    }

    public void setAddr_region(String addr_region) {
        this.addr_region = addr_region;
    }

    public String getAddr_phone() {
        return addr_phone;
    }

    public void setAddr_phone(String addr_phone) {
        this.addr_phone = addr_phone;
    }

    public int getAddr_default() {
        return addr_default;
    }

    public void setAddr_default(int addr_default) {
        this.addr_default = addr_default;
    }


    @Override
    public int compareTo(Address o) {
        if( this.addr_id != o.addr_id ){
            return 1;
        }
        return 0;
    }
}
