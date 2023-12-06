package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int user_id;
    private String user_acc;

    private String user_passwd;

    private String user_phone;
    private char user_gender;
    private String user_info;
    private String user_register_time;



    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", user_acc='" + user_acc + '\'' +
                ", user_passwd='" + user_passwd + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_gender=" + user_gender +
                ", user_info='" + user_info + '\'' +
                ", user_register_time='" + user_register_time + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_acc() {
        return user_acc;
    }

    public void setUser_acc(String user_acc) {
        this.user_acc = user_acc;
    }

    public String getUser_passwd() {
        return user_passwd;
    }

    public void setUser_passwd(String user_passwd) {
        this.user_passwd = user_passwd;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public char getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(char user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }

    public String getUser_register_time() {
        return user_register_time;
    }

    public void setUser_register_time(String user_register_time) {
        this.user_register_time = user_register_time;
    }
}
